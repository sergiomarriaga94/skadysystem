/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.dao;


import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author sergio.marriaga
 */
public class usuarioDao {
  /*  
     public String consultarNombre(String cedula) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q=em.createQuery("SELECT a FROM Usuario a WHERE a.cedula=:cedula and a.password=:password");
        Usuario usuario=(Usuario) session.get(Usuario.class, cedula);
        //Usuario paleta = (Paleta) session.get(Paleta.class, codigo);
        session.close();
        if (usuario != null) {
            return usuario.getNombre();
        } else {
            return "no lo encontro";
        }*/
    }

