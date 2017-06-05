/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.dao;

import com.udea.skadysystem.persistencia.VentaProducto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sergio.marriaga
 */
public class ventaProductoDao {
    public void nuevaPaletaVenta(VentaProducto  paleta){
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction transaction=null;
    try{
        sessionFactory=HibernateUtil.getSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.save(paleta);
        transaction.commit();
        session.close();
    }catch(HibernateException e){
        transaction.rollback();
        throw new RuntimeException("No se pudo agregar la paleta a la base de datos");
    }
    }
}
