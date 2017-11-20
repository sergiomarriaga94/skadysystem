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
public class UsuarioFacade extends IAbstractFacade<Usuario> implements IUsuarioFacadeLocal {

    @PersistenceContext(unitName = "skadySystemPU")
    private EntityManager gv_em;

    @Override
    protected EntityManager getEntityManager() {
        return gv_em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public boolean checklogin(String cedula, String password) {
        Query lv_q = gv_em.createQuery("SELECT a FROM Usuario a WHERE a.cedula=:cedula and a.password=:password");
        System.out.println("se tiene el documento" + cedula);
        System.out.println("se tiene el passo" + password);

        lv_q.setParameter("cedula", cedula);
        lv_q.setParameter("password",password);
        
        return lv_q.getResultList().size()>0;
    }

    @Override
    public String traerNombre(String cedula) {
        Query lv_q = gv_em.createQuery("SELECT a FROM Usuario a WHERE a.cedula=:cedula");
        lv_q.setParameter("cedula", cedula);
        String nombre=((Usuario)(lv_q.getSingleResult())).getNombre();
        System.out.println(nombre);
        return ((Usuario)(lv_q.getSingleResult())).getNombre();
    }    
}


