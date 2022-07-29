/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajavaweb.facade;

import com.aulajavaweb.entity.Uf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kétlin
 */
@Stateless
public class UfFacade extends AbstractFacade<Uf> {

    @PersistenceContext(unitName = "WebApplicationComprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UfFacade() {
        super(Uf.class);
    }
    
}
