/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.controller;

import com.udea.skadysystem.dao.usuarioDao;
import com.udea.skadysystem.facades.UsuarioFacadeLocal;
import com.udea.skadysystem.wssoap.PaletaWs_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author sergio.marriaga
 */
public class usuarioServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/paletas_service/paletaWs.wsdl")
    private PaletaWs_Service service;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

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
        com.udea.skadysystem.wssoap.PaletaWs port = service.getPaletaWsPort();
        return port.agregarEmpleado(nombre, cedula, password, telefono, celular, sede);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuarioDao dao = new usuarioDao();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "nuevoEmpleado.jsp";
            if ("Ingresar".equals(action)) {
                String User = request.getParameter("cedula");
                String Password = request.getParameter("password");

                if (usuarioFacade.checklogin(User, Password)) {
                    request.getSession().setAttribute("Ingresar", User);
                    String nombre = usuarioFacade.traerNombre(User);
                    request.getSession().setAttribute("nombre", nombre);
                    url = "menu.jsp";
                } else {
                    url = "index.jsp?error=1";
                }
            }
            String mensaje = "";
            if ("guardarEmpleado".equals(action)) {
                String nombre = request.getParameter("nombre");
                String cedula = request.getParameter("cedula");
                String password = request.getParameter("password");
                String telefono = request.getParameter("telefono");
                String celular = request.getParameter("celular");
                String sede = request.getParameter("sede");
                if (sede.equals("1")) {
                    String envio = agregarEmpleado(nombre, cedula, password, telefono, celular, Integer.parseInt(sede));
                    mensaje = "El empleado fue guardado con exito";
                    request.getSession().setAttribute("mensaje", mensaje);
                    System.out.println("se guardo la siguiente información" + envio);
                    url = "nuevoEmpleado.jsp";
                } else {
                    mensaje = "la sede ingresada es incorrecta";
                    url="nuevoEmpleado.jsp";
                    request.getSession().setAttribute("mensaje", mensaje);
                }
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

}
