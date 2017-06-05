/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.facades;

import com.udea.skadysystem.persistencia.Paleta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio.marriaga
 */
@Stateless
public class PaletaFacade extends AbstractFacade<Paleta> implements PaletaFacadeLocal {

    @PersistenceContext(unitName = "skadySystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaletaFacade() {
        super(Paleta.class);
    }
    
}
