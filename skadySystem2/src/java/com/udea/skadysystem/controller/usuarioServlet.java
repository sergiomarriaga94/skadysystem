/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.controller;

import com.udea.skadysystem.dao.UsuarioDao;
import com.udea.skadysystem.wssoap.PaletaWs_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import com.udea.skadysystem.facades.IUsuarioFacadeLocal;

/**
 *
 * @author sergio.marriaga
 */
public class usuarioServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/paletas_service/paletaWs.wsdl")
    private PaletaWs_Service service;

    @EJB
    private IUsuarioFacadeLocal gv_usuario_facade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String agregarEmpleado(java.lang.String nombre, java.lang.String cedula, java.lang.String password, java.lang.String telefono, java.lang.String celular, int sede) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.skadysystem.wssoap.PaletaWs lv_port = service.getPaletaWsPort();
        return lv_port.agregarEmpleado(nombre, cedula, password, telefono, celular, sede);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDao lv_dao = new UsuarioDao();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter lv_out = response.getWriter();
        try {
            String lv_action = request.getParameter("action");
            String lv_url = "nuevoEmpleado.jsp";
            if ("Ingresar".equals(lv_action)) {
                String lv_user = request.getParameter("cedula");
                String lv_password = request.getParameter("password");

                if (gv_usuario_facade.checklogin(lv_user, lv_password)) {
                    request.getSession().setAttribute("Ingresar", lv_user);
                    String lv_nombre = gv_usuario_facade.traerNombre(lv_user);
                    request.getSession().setAttribute("nombre", lv_nombre);
                    lv_url = "menu.jsp";
                } else {
                    lv_url = "index.jsp?error=1";
                }
            }
            String lv_mensaje = "";
            if ("guardarEmpleado".equals(lv_action)) {
                String lv_nombre = request.getParameter("nombre");
                String lv_cedula = request.getParameter("cedula");
                String lv_password = request.getParameter("password");
                String lv_telefono = request.getParameter("telefono");
                String lv_celular = request.getParameter("celular");
                String lv_sede = request.getParameter("sede");
                if (lv_sede.equals("1")) {
                    String lv_envio = agregarEmpleado(lv_nombre, lv_cedula, lv_password, lv_telefono, lv_celular, Integer.parseInt(lv_sede));
                    lv_mensaje = "El empleado fue guardado con exito";
                    request.getSession().setAttribute("mensaje", lv_mensaje);
                    System.out.println("se guardo la siguiente información" + lv_envio);
                    lv_url = "nuevoEmpleado.jsp";
                } else {
                    lv_mensaje = "la sede ingresada es incorrecta";
                    lv_url="nuevoEmpleado.jsp";
                    request.getSession().setAttribute("mensaje", lv_mensaje);
                }
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

}
