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
public class ventaDao {

    public void nuevaVenta(Venta venta) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(venta);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException("No se pudo agregar la venta a la base de datos");
        }
    }

    public Venta nose() {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Venta order by id DESC");
            query.setMaxResults(1);
            Venta last = (Venta) query.uniqueResult();
            session.close();
            return last;
        } catch (HibernateException e) {
            throw new RuntimeException("No se pudo encontrar el dato");
        }

    }
}
