/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.controller;

import com.udea.skadysystem.dao.HibernateUtil;
import com.udea.skadysystem.dao.VentaDao;
import com.udea.skadysystem.dao.VentaProductoDao;
import com.udea.skadysystem.persistencia.Paleta;
import com.udea.skadysystem.persistencia.Venta;
import com.udea.skadysystem.persistencia.VentaProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.udea.skadysystem.facades.IPaletaFacadeLocal;

/**
 *
 * @author sergio.marriaga
 */
public class ventasServlet extends HttpServlet {

    @EJB
    private IPaletaFacadeLocal gv_paleta_facade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter lv_out = response.getWriter();
        try {
            String lv_action = request.getParameter("action");
            String lv_url = "menu.jsp";

            double lv_total_venta = 0;
            String lv_mensaje = "";
            VentaProducto lv_venta_producto;
            if ("agregarPaleta".equals(lv_action)) {
                String lv_codigo = request.getParameter("codigoPaleta");
                String lv_cantidad = request.getParameter("cantidad");

                Paleta lv_p = consultarPaleta(Integer.parseInt(lv_codigo));
                if (lv_p == null) {
                    lv_mensaje = "El codigo ingresado es invalido";
                    request.getSession().setAttribute("mensaje", lv_mensaje);
                    lv_url = "venta.jsp";
                } else {
                    lv_venta_producto = new VentaProducto(0, lv_p.getNombre(), Integer.parseInt(lv_codigo), Integer.parseInt(lv_cantidad),
                            lv_p.getPrecio());

                    Venta.paletas.add(lv_venta_producto);
                    // Paleta.cantidad.add(Double.parseDouble(cantidad));
                    request.getSession().setAttribute("paletas", Venta.paletas);
                    request.getSession().setAttribute("mensaje", lv_mensaje);
                    //request.getSession().setAttribute("cantidad", Paleta.cantidad.get(Paleta.cantidad.size()-1));
                    lv_url = "venta.jsp";

                    lv_total_venta = Venta.paletas.stream().map((v) -> (v.getPrecio() * v.getCantidad())).reduce(lv_total_venta, (accumulator, _item) -> accumulator + _item);
                    request.getSession().setAttribute("totalVenta", lv_total_venta);
                }
            }
            if ("cancelarVenta".equals(lv_action)) {
                Venta.paletas.clear();
                lv_total_venta = 0;
                request.getSession().setAttribute("totalVenta", lv_total_venta);
                request.getSession().setAttribute("paletas", Venta.paletas);
                request.getSession().setAttribute("mensaje", lv_mensaje);
                lv_url = "venta.jsp";
            }
            if ("venta".equals(lv_action)) {
                if (Venta.paletas.size() == 0) {
                    lv_mensaje = "No se ha registrado ningun producto";
                    lv_url = "venta.jsp";
                    request.getSession().setAttribute("mensaje", lv_mensaje);
                } else {
                    lv_total_venta = Venta.paletas.stream().map((v) -> (v.getPrecio() * v.getCantidad())).reduce(lv_total_venta, (accumulator, _item) -> accumulator + _item);
                    Venta lv_v = new Venta(lv_total_venta);
                    VentaDao lv_dao = new VentaDao();
                    lv_dao.nuevaVenta(lv_v);
                    lv_mensaje = "Venta realizada con exito";                   
                    lv_total_venta = 0;
                    lv_v = lv_dao.nose();
                    VentaProductoDao lv_productoDao = new VentaProductoDao();
                    for (VentaProducto d : Venta.paletas) {
                        d.setCodigoVenta(lv_v.getId());
                        lv_productoDao.nuevaPaletaVenta(d);
                    }
                    Venta.paletas.clear();
                    request.getSession().setAttribute("totalVenta", lv_total_venta);
                    request.getSession().setAttribute("paletas", Venta.paletas);
                    request.getSession().setAttribute("mensaje", lv_mensaje);
                    lv_url = "venta.jsp";
                }
                //Paleta.cantidad.clear();
            }
            response.sendRedirect(lv_url);
        } finally {
            lv_out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Paleta consultarPaleta(int codigo) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Paleta paleta = (Paleta) session.get(Paleta.class, codigo);
        session.close();
        if (paleta != null) {
            return paleta;
        } else {
            return null;
        }
    }
}
