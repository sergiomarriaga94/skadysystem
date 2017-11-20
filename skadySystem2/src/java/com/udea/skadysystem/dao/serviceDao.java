/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.dao;

import com.udea.skadysystem.persistencia.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author sergio.marriaga
 */
public class ServiceDao {
    public List<Usuario> getEmpleados() {
        SessionFactory lv_factory = HibernateUtil.getSessionFactory();
        Session lv_s = lv_factory.openSession();
        Query lv_q = lv_s.createQuery("from Usuario");
        List<Usuario> lv_empleados = lv_q.list();
        return lv_empleados;
    }
}
