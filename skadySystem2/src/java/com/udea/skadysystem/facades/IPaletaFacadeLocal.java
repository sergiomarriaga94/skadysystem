/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.facades;

import com.udea.skadysystem.persistencia.Paleta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio.marriaga
 */
@Local
public interface IPaletaFacadeLocal {

    void create(Paleta paleta);

    void edit(Paleta paleta);

    void remove(Paleta paleta);

    Paleta find(Object id);

    List<Paleta> findAll();

    List<Paleta> findRange(int[] range);

    int count();
    
}
