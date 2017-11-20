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
public class VentaProductoDao {
    public void nuevaPaletaVenta(VentaProducto  paleta){
    SessionFactory lv_session_factory = null;
    Session lv_session = null;
    Transaction lv_transaction = null;
    try{
        lv_session_factory=HibernateUtil.getSessionFactory();
        lv_session=lv_session_factory.openSession();
        lv_transaction=lv_session.beginTransaction();
        lv_session.save(paleta);
        lv_transaction.commit();
        lv_session.close();
    }catch(HibernateException e){
        lv_transaction.rollback();
        throw new RuntimeException("No se pudo agregar la paleta a la base de datos");
    }
    }
}
