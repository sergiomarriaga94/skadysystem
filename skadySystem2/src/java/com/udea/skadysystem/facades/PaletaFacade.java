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
public class PaletaFacade extends IAbstractFacade<Paleta> implements IPaletaFacadeLocal {

    @PersistenceContext(unitName = "skadySystemPU")
    private EntityManager gv_em;

    @Override
    protected EntityManager getEntityManager() {
        return gv_em;
    }

    public PaletaFacade() {
        super(Paleta.class);
    }
    
}
