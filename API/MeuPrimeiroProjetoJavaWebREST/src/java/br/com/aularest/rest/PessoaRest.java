/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aularest.rest;

import br.com.aularest.entity.Pessoa;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pessoa")
public class PessoaRest {

    private Pessoa pessoa = new Pessoa(1, "Pedro", 50, "Ernestina");

    @GET

    @Path("saudacao")

    @Produces(MediaType.TEXT_PLAIN)

    public String saudacao() {
        return "Olá mundo!";
    }

    /**
     * método que retorna um JSON contendo o objeto pessoa
     *
     * @return
     */
    @GET
    @Path("find")
    @Produces({MediaType.APPLICATION_JSON})
    public Pessoa pessoa() {
        return pessoa;
    }

    /**
     * Método utilizado para inserir pessoa
     *
     * @param mensagem
     * @param entity
     * @return
     */
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Pessoa create(@HeaderParam("mensagem") String mensagem, Pessoa entity) {
        Pessoa pessoaEntity = entity;
        pessoaEntity.setMensagem(mensagem);
        System.out.println(pessoaEntity);
        return pessoaEntity;
    }

    @PUT
    @Path("edit")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Pessoa editTk(Pessoa entity) {
        pessoa = entity;
        System.out.println(pessoa);
        return pessoa;
    }

    @DELETE
    @Path("remove")
    @Produces({MediaType.APPLICATION_JSON})
    public Pessoa remove() {
        pessoa = new Pessoa();
        return pessoa;
    }
}
