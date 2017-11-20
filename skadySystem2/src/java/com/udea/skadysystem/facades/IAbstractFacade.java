/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.skadysystem.facades;

import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author sergio.marriaga
 */
public abstract class IAbstractFacade<T> {

    private Class<T> gv_entity_class;

    public IAbstractFacade(Class<T> entityClass) {
        this.gv_entity_class = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(gv_entity_class, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery lv_cq = getEntityManager().getCriteriaBuilder().createQuery();
        lv_cq.select(lv_cq.from(gv_entity_class));
        return getEntityManager().createQuery(lv_cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery lv_cq = getEntityManager().getCriteriaBuilder().createQuery();
        lv_cq.select(lv_cq.from(gv_entity_class));
        javax.persistence.Query lv_q = getEntityManager().createQuery(lv_cq);
        lv_q.setMaxResults(range[1] - range[0] + 1);
        lv_q.setFirstResult(range[0]);
        return lv_q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery lv_cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = lv_cq.from(gv_entity_class);
        lv_cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query lv_q = getEntityManager().createQuery(lv_cq);
        return ((Long) lv_q.getSingleResult()).intValue();
    }
    
}
