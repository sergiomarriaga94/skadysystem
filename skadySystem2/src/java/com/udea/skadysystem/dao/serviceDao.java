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
public class serviceDao {
    public List<Usuario> getEmpleados() {
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session s=factory.openSession();
        Query q=s.createQuery("from Usuario");
        List<Usuario> empleados=q.list();
        return empleados;
    }
}
