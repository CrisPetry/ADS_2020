package com.dados.util;

import com.dados.entity.Autor;
import com.dados.entity.Livro;
import com.dados.entity.Usuario;
import com.dados.entity.Venda;
import java.util.List;

/**
 * @author xSandman
 */
public interface IGerenciadorProjetos {

    
    
    
    //CRUD AUTOR
    public void incluirAutor(Autor autor);
    
    public void atualizaAutor(Autor autor);
    
    public Autor removeAutor(String nome);
    
    
    
    
    //CRUD LIVRO
    public void incluirLivro(Livro livro);
    
    public void atualizaLivro(Livro livro);
    
    public Livro removeLivro(String titulo);
    
    public Autor obterAutorPorNome(String nome);
    
    
    
    //CRUD VENDA
    public void incluirVenda(Venda venda);
    
    public void removerVenda (Venda venda);
    
    public void atualizaVenda(Venda venda);
    
    public Livro obterLivroPorTitulo(String titulo);
    
    
    
    
    
    
    
    //inclui usuario
    public void incluirUsuario(Usuario usuario);
    
    public void removerUsuario(String nome);
    
    public void atualizarUsuario(Usuario usuario);
    
    public Venda obterVendaPorId(int id);
    
    
    
    //consultas
    public List<Livro> consultaTodosLivros();
    
    public List<Usuario> consultaTodosUsuarios();
    
    public List<Venda> consultaVenda();
    
  
}
