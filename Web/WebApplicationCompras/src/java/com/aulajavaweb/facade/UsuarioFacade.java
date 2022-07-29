/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajavaweb.facade;

import com.aulajavaweb.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kétlin
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WebApplicationComprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findUsuarioByLogin(String login){
        Usuario usuario = null;
        try{
            Query query = getEntityManager().createNamedQuery("Usuario.findByUsrLogin");
            query.setParameter("usrLogin", login);
            query.setMaxResults(1);
            
            if(!query.getResultList().isEmpty()){
                usuario =  (Usuario) query.getSingleResult();
            }else{
                System.out.println("Nenhum resultado localizado para findByUsrLogin");
            }
        }catch(Exception e){
                    System.out.println("Erros: " + e);        }
        return usuario;
    }
    
}
