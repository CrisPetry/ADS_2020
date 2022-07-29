/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajavaweb.util;

import com.aulajavaweb.entity.Usuario;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kétlin
 */
public class UtilSession {

    //sessão
    //captura a sessão do contexto criado pelo JavaServer Faces
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final javax.servlet.http.HttpSession session = (javax.servlet.http.HttpSession) context.getExternalContext().getSession(false);

    /**
     * método que retorna o código do usuário logado
     *
     * @return
     */
    public Integer getUsuarioCodigoLogado() {
        return (Integer) session.getAttribute("logado");
    }

    /**
     * método que monta um objeto usuário e insere o código do usuário logado
     *
     * @return
     */
    public Usuario getUsuarioLogado() {
        Usuario user = new Usuario();
        user.setUsrCodigo(getUsuarioCodigoLogado());
        return user;
    }
}
