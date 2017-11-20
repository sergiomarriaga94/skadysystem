/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.rest;

import com.udea.skadysystem.dao.HibernateUtil;
import com.udea.skadysystem.persistencia.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.udea.skadysystem.dao.ServiceDao;
import javax.ws.rs.Produces;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sergio.marriaga
 */

@Path("/Empleado")
public class exponerRest {

    /**
     * Web service operation
     * @return 
     */
   @GET
   @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getEmpleados(){
        ServiceDao lv_dao=new ServiceDao(); 
        return lv_dao.getEmpleados();
    }
    }
    
    

