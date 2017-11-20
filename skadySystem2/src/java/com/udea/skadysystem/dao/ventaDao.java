/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.dao;

import com.udea.skadysystem.persistencia.Venta;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sergio.marriaga
 */
public class VentaDao {

    public void nuevaVenta(Venta venta) {
        SessionFactory lv_session_factory = null;
        Session lv_session = null;
        Transaction lv_transaction = null;
        try {
            lv_session_factory = HibernateUtil.getSessionFactory();
            lv_session = lv_session_factory.openSession();
            lv_transaction = lv_session.beginTransaction();
            lv_session.save(venta);
            lv_transaction.commit();
            lv_session.close();
        } catch (HibernateException e) {
            lv_transaction.rollback();
            throw new RuntimeException("No se pudo agregar la venta a la base de datos");
        }
    }

    public Venta nose() {
        SessionFactory lv_session_factory = null;
        Session lv_session = null;
        try {
            lv_session_factory = HibernateUtil.getSessionFactory();
            lv_session = lv_session_factory.openSession();
            Query lv_query = lv_session.createQuery("from Venta order by id DESC");
            lv_query.setMaxResults(1);
            Venta lv_last = (Venta) lv_query.uniqueResult();
            lv_session.close();
            return lv_last;
        } catch (HibernateException e) {
            throw new RuntimeException("No se pudo encontrar el dato");
        }

    }
}
