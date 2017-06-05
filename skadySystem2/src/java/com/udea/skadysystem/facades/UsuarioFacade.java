/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.facades;

import com.udea.skadysystem.persistencia.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sergio.marriaga
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "skadySystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public boolean checklogin(String cedula, String password) {
        Query q=em.createQuery("SELECT a FROM Usuario a WHERE a.cedula=:cedula and a.password=:password");
        System.out.println("se tiene el documento" + cedula);
        System.out.println("se tiene el passo" + password);

        q.setParameter("cedula", cedula);
        q.setParameter("password",password);
        
        return q.getResultList().size()>0;
    }

    @Override
    public String traerNombre(String cedula) {
        Query q=em.createQuery("SELECT a FROM Usuario a WHERE a.cedula=:cedula");
        q.setParameter("cedula", cedula);
        String nombre=((Usuario)(q.getSingleResult())).getNombre();
        System.out.println(nombre);
        return ((Usuario)(q.getSingleResult())).getNombre();
    }
    
    }


