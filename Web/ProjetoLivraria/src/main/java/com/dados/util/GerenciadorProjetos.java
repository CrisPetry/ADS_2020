package com.dados.util;

import com.dados.entity.Autor;
import com.dados.entity.Livro;
import com.dados.entity.Usuario;
import com.dados.entity.Venda;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import java.util.List;

/**
 *
 * @author xSandman
 */
public class GerenciadorProjetos implements IGerenciadorProjetos {

    //------------------------------------------CRUD AUTOR------------------------------------------------//
    @Override
    public void incluirAutor(Autor autor) {
        Datastore datastore = Conection.obterConexao();
        datastore.save(autor);
    }

    @Override
    public void atualizaAutor(Autor autor) {
        Datastore datastore = Conection.obterConexao();

        Query<Autor> query = datastore
                .createQuery(Autor.class).field("id").equal(autor.getId());

        UpdateOperations<Autor> updates = datastore
                .createUpdateOperations(Autor.class)
                .set("id", autor.getId())
                .set("nome", autor.getNome())
                .set("idade", autor.getIdade());
        datastore.update(query, updates);
    }

    
    
    
    
    @Override
    public Autor removeAutor(String nome) {
        try {
            Datastore datastore = Conection.obterConexao();
            Query<Autor> query = datastore.createQuery(Autor.class).field("nome").equal(nome);
            datastore.delete(query);
            System.out.println("Removido com sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //------------------------------------------CRUD LIVRO------------------------------------------------//
    @Override
    public void incluirLivro(Livro livro) {
        Datastore datastore = Conection.obterConexao();
        datastore.save(livro);
    }

    @Override
    public Autor obterAutorPorNome(String nome) {
        Datastore datastore = Conection.obterConexao();
        Query<Autor> query = datastore.createQuery(Autor.class).field("nome").equal(nome);
        List<Autor> listAutors = query.find().toList();

        if (listAutors != null && !listAutors.isEmpty()) {
            return listAutors.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Livro removeLivro(String titulo) {
        try {
            Datastore datastore = Conection.obterConexao();
            Query<Livro> query = datastore.createQuery(Livro.class).field("titulo").equal(titulo);
            datastore.delete(query);
            System.out.println("Removido com sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void atualizaLivro(Livro livro) {
        Datastore datastore = Conection.obterConexao();

        Query<Livro> query = datastore
                .createQuery(Livro.class).field("id").equal(livro.getId());

        UpdateOperations<Livro> updates = datastore
                .createUpdateOperations(Livro.class)
                .set("titulo", livro.getTitulo())
                .set("ano", livro.getAno())
                .set("editora", livro.getEditora())
                .set("autor", livro.getAutor());

        datastore.update(query, updates);
    }

    
    
   
    
    //------------------------------------------CRUD VENDA------------------------------------------------//
    @Override
    public void incluirVenda(Venda venda) {
        Datastore datastore = Conection.obterConexao();
        datastore.save(venda);
    }

    @Override
    public void removerVenda(Venda venda) {
        try {
            Datastore datastore = Conection.obterConexao();
            Query<Venda> query = datastore.createQuery(Venda.class).field("id").equal(venda.getId());
            datastore.delete(query);
            System.out.println("Removido com sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void atualizaVenda(Venda venda) {
        Datastore datastore = Conection.obterConexao();

        Query<Venda> query = datastore
                .createQuery(Venda.class).field("id").equal(venda.getId());

        UpdateOperations<Venda> updates = datastore
                .createUpdateOperations(Venda.class)
                .set("id", venda.getId())
                .set("preco", venda.getPreco())
                .set("Livro", venda.getLivros());
        datastore.update(query, updates);
    }

    
    //--------------------------------------------------------------------------------------------//

    
    
    
     @Override
    public void incluirUsuario(Usuario usuario) {
        Datastore datastore = Conection.obterConexao();
        datastore.save(usuario);
    }

    @Override
    public void removerUsuario(String nome) {
        try {
            Datastore datastore = Conection.obterConexao();
            Query<Usuario> query = datastore.createQuery(Usuario.class).field("nome").equal(nome);
            datastore.delete(query);
            System.out.println("Removido com sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void atualizarUsuario(Usuario usuario) {
        Datastore datastore = Conection.obterConexao();

        Query<Usuario> query = datastore
                .createQuery(Usuario.class).field("id").equal(usuario.getId());

        UpdateOperations<Usuario> updates = datastore
                .createUpdateOperations(Usuario.class)
                .set("id", usuario.getId())
                .set("nome", usuario.getNome())
                .set("cpf", usuario.getCpf())
                .set("Venda", usuario.getVenda());
        datastore.update(query, updates);
    }

    @Override
    public Venda obterVendaPorId(int id) {
        Datastore datastore = Conection.obterConexao();
        Query<Venda> query = datastore
                .createQuery(Venda.class).field("id").equal(id);
        
        
        List<Venda> listVenda = query.find().toList();

        if (listVenda != null && !listVenda.isEmpty()) {
            return listVenda.get(0);
        } else {
            return null;
        }
    }
    
    
   
    
    
    

    //------------------------------------------CONSULTAS------------------------------------------------//
    @Override
    public Livro obterLivroPorTitulo(String titulo) {
        Datastore datastore = Conection.obterConexao();
        Query<Livro> query = datastore
                .createQuery(Livro.class).field("titulo").equal(titulo);
        List<Livro> listaLivro = query.find().toList();
        if (listaLivro != null && !listaLivro.isEmpty()) {
            return listaLivro.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Livro> consultaTodosLivros() {
        Datastore datastore = Conection.obterConexao();
        Query<Livro> query = datastore
                .createQuery(Livro.class);
        List<Livro> listBook = query.find().toList();
        if (listBook != null && !listBook.isEmpty()) {
            return listBook;
        } else {
            return null;
        }
    }

    @Override
    public List<Usuario> consultaTodosUsuarios() {
        Datastore datastore = Conection.obterConexao();
        Query<Usuario> query = datastore
                .createQuery(Usuario.class);
        List<Usuario> listUsr = query.find().toList();
        if (listUsr != null && !listUsr.isEmpty()) {
            return listUsr;
        } else {
            return null;
        }
    }

    @Override
    public List<Venda> consultaVenda() {
        Datastore datastore = Conection.obterConexao();
        Query<Venda> query = datastore.find(Venda.class);
        List<Venda> listVenda = query.find().toList();

        return listVenda;
    }

   

   
}
