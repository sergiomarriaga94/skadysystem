/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.controller;

import com.udea.skadysystem.dao.HibernateUtil;
import com.udea.skadysystem.dao.ventaDao;
import com.udea.skadysystem.dao.ventaProductoDao;
import com.udea.skadysystem.facades.PaletaFacadeLocal;
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

/**
 *
 * @author sergio.marriaga
 */
public class ventasServlet extends HttpServlet {

    @EJB
    private PaletaFacadeLocal paletaFacade;

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
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "menu.jsp";

            double totalVenta = 0;
            String mensaje = "";
            VentaProducto ventaProducto;
            if ("agregarPaleta".equals(action)) {
                String codigo = request.getParameter("codigoPaleta");
                String cantidad = request.getParameter("cantidad");

                Paleta p = consultarPaleta(Integer.parseInt(codigo));
                if (p == null) {
                    mensaje = "El codigo ingresado es invalido";
                    request.getSession().setAttribute("mensaje", mensaje);
                    url = "venta.jsp";
                } else {
                    ventaProducto = new VentaProducto(0, p.getNombre(), Integer.parseInt(codigo), Integer.parseInt(cantidad),
                            p.getPrecio());

                    Venta.paletas.add(ventaProducto);
                    // Paleta.cantidad.add(Double.parseDouble(cantidad));
                    request.getSession().setAttribute("paletas", Venta.paletas);
                    request.getSession().setAttribute("mensaje", mensaje);
                    //request.getSession().setAttribute("cantidad", Paleta.cantidad.get(Paleta.cantidad.size()-1));
                    url = "venta.jsp";

                    totalVenta = Venta.paletas.stream().map((v) -> (v.getPrecio() * v.getCantidad())).reduce(totalVenta, (accumulator, _item) -> accumulator + _item);
                    request.getSession().setAttribute("totalVenta", totalVenta);
                }
            }
            if ("cancelarVenta".equals(action)) {
                Venta.paletas.clear();
                totalVenta = 0;
                request.getSession().setAttribute("totalVenta", totalVenta);
                request.getSession().setAttribute("paletas", Venta.paletas);
                request.getSession().setAttribute("mensaje", mensaje);
                url = "venta.jsp";
            }
            if ("venta".equals(action)) {
                if (Venta.paletas.size() == 0) {
                    mensaje = "No se ha registrado ningun producto";
                    url = "venta.jsp";
                    request.getSession().setAttribute("mensaje", mensaje);
                } else {
                    totalVenta = Venta.paletas.stream().map((v) -> (v.getPrecio() * v.getCantidad())).reduce(totalVenta, (accumulator, _item) -> accumulator + _item);
                    Venta v = new Venta(totalVenta);
                    ventaDao dao = new ventaDao();
                    dao.nuevaVenta(v);
                    mensaje = "Venta realizada con exito";                   
                    totalVenta = 0;
                    v = dao.nose();
                    ventaProductoDao productoDao = new ventaProductoDao();
                    for (VentaProducto d : Venta.paletas) {
                        d.setCodigoVenta(v.getId());
                        productoDao.nuevaPaletaVenta(d);
                    }
                    Venta.paletas.clear();
                    request.getSession().setAttribute("totalVenta", totalVenta);
                    request.getSession().setAttribute("paletas", Venta.paletas);
                    request.getSession().setAttribute("mensaje", mensaje);
                    url = "venta.jsp";
                }
                //Paleta.cantidad.clear();
            }
            response.sendRedirect(url);
        } finally {
            out.close();
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
