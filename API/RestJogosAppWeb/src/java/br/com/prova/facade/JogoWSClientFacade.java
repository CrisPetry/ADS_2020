/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prova.facade;

import br.com.prova.entity.TbJogo;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author xSandman
 */
public class JogoWSClientFacade {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/JogosRestAPI/webresources";

    public JogoWSClientFacade() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("jogos");
    }

    public List<TbJogo> listAll() throws ClientErrorException {
        List<TbJogo> list;
        WebTarget resource = webTarget;
        resource = resource.path("listAll");
        list = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .get(new GenericType<List<TbJogo>>() {
                });
        return list;
    }

    public TbJogo findById(String id) throws ClientErrorException {
        TbJogo tbJogo;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByID/{0}", new Object[]{id}));
        tbJogo = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<TbJogo>() {
        });
        return tbJogo;
    }

    public List<TbJogo> findByPartTitulo(String titulo) throws ClientErrorException {
        List<TbJogo> list;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("findByPartTitulo/{0}", new Object[]{titulo}));
        list = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<TbJogo>>() {
        });
        return list;
    }

    public void create(TbJogo entity) throws ClientErrorException {
        webTarget.path("add").request().post(Entity.entity(entity, MediaType.APPLICATION_JSON));
    }

    public void edit(TbJogo entity) throws ClientErrorException {
        webTarget.path("edit").request().put(Entity.entity(entity, MediaType.APPLICATION_JSON));
    }

    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("delete/{0}", new Object[]{id})).request().delete();
    }
}
