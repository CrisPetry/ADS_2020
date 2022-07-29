package com.dados.main;

import com.dados.entity.Autor;
import com.dados.entity.Livro;
import com.dados.entity.Usuario;
import com.dados.entity.Venda;
import com.dados.util.GerenciadorProjetos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xSandman
 */
public class Principal {

    private static GerenciadorProjetos g = new GerenciadorProjetos();

    public static void main(String[] args) {

        
        //---------------------------------------CRUD AUTOR---------------------------------------//
        
        //<--Add-->
        g.incluirAutor(new Autor(1, "Neil Gaiman", 61));
        g.incluirAutor(new Autor(2, "Stephen King", 74));
        g.incluirAutor(new Autor(3, "Alan Moore", 68));
        g.incluirAutor(new Autor(4, "Joe Hill", 49));
        g.incluirAutor(new Autor(5, "Affonso Solano", 40));
        
        
        
        //<--update-->
        /*Autor autor = new Autor(1, "Niel Gaiman", 61);
        g.atualizaAutor(autor);*/
        
        
        
        //<--remove-->
        //g.removeAutor("Joe Hill");
        
        
        //---------------------------------------CRUD LIVRO---------------------------------------//
        
        //<--Add-->
        g.incluirLivro(new Livro(1, "Coraline", "2002", "Panini", g.obterAutorPorNome("Neil Gaiman")));
        g.incluirLivro(new Livro(2, "Cemitério Maldito", "1983", "Suma", g.obterAutorPorNome("Stephen King")));
        g.incluirLivro(new Livro(3, "Watchmen", "1987", "Panini", g.obterAutorPorNome("Alan Moore")));
        g.incluirLivro(new Livro(4, "Nosferatu", "2013", "Arqueiro", g.obterAutorPorNome("Joe Hill")));
        
        
   
        
        //<--update-->
        /*Livro livro = new Livro(1, "O Espadachim de Carvão", "2013", "Fantasy / Casa da Palavra",
        g.obterAutorPorNome("Affonso Solano"));
        g.atualizaLivro(livro);*/
        
       
        
        
        //<--remove-->
        //g.removeLivro("Nosferatu");
        
    
 
        
       //---------------------------------------CRUD VENDA---------------------------------------//
       
       //<--Add-->
       Venda venda1 = new Venda(1, 37.08);

        //referencia livro
        List<Livro> livroDaVenda = new ArrayList<>();
        livroDaVenda.add(g.obterLivroPorTitulo("Coraline"));
        venda1.setLivros(livroDaVenda);
        g.incluirVenda(venda1);
        

        
        
        
        
        //<--update-->
        /*Venda venda = new Venda(1, 37.08);
        
        ArrayList<Usuario> updateUsuario = new ArrayList();
        updateUsuario.add(new Usuario(3, "Pedro", "02304369954")); 
        
        ArrayList<Livro> updateLivro = new ArrayList();
        updateLivro.add(new Livro(5, "IT", "1986", "Suma", g.obterAutorPorNome("Stephen King")));
        
        venda.setLivros(updateLivro);
        venda.setUsuarios(updateUsuario);
        venda.setPreco(39.90);
        g.atualizaVenda(venda);*/
        

        
        
        
        //<--remove-->
        //g.removerVenda(venda1);
        
        
        
          //---------------------------------------CRUD USUARIO---------------------------------------//
        
        //<--Add-->
        Usuario usuario = new Usuario(1, "xSandman", "02705570080");

         //referencia venda
        List<Venda> vendaUsr = new ArrayList<>();
        vendaUsr.add(g.obterVendaPorId(1));
        usuario.setVenda(vendaUsr);
        g.incluirUsuario(usuario);
        
        
        
         //<--update-->
        Usuario usr1 = new Usuario(1, "Niltek94", "01072179024");
        g.atualizarUsuario(usr1);
        
        //referencia venda
        List<Venda> vendaUpdate = new ArrayList<>();
        vendaUpdate.add(g.obterVendaPorId(1));
        usr1.setVenda(vendaUpdate);
        g.incluirUsuario(usr1);
       
   
        //<--remove-->
        //g.removerUsuario("xSandman");
        
        
        
        
        //-----------------------------------CONSULTAS---------------------------------------//
        List<Livro> listaLivros = g.consultaTodosLivros();
        System.out.println("                                                                     ");
        System.out.println("<------------------------LIVROS------------------------------------->");
        System.out.println("                                                                     ");
        for (Livro l : listaLivros) {
            System.out.println(l.getId() + " " + l.getTitulo() + " " + "-" + " " + l.getEditora());
            System.out.println("-----------------------------------------------------------------");
        }
       

        
        
        
        List<Usuario> listUsr = g.consultaTodosUsuarios();
        System.out.println("                                                                     ");
        System.out.println("<-----------------------USUÁRIOS------------------------------------>");
        System.out.println("                                                                     ");
        for (Usuario u : listUsr) {
            System.out.println(u.getId() + " " + u.getNome() + " " + "-" + " " + u.getCpf());
            System.out.println("------------------------------------------------------------------");
        }
        

        
        
        
        
        List<Venda> listaVenda = g.consultaVenda();
        System.out.println("                                                                      ");
        System.out.println("<-------------------------VENDAS------------------------------------->");
        for (Venda v : listaVenda) {
            //System.out.println(v.getId() + " " + v.getLivros() + " " + v.getPreco() + " " + v.getUsuarios());
            System.out.println("ID: " + v.getId() + " " + "-" + " Preço: " + v.getPreco());
            System.out.println("------------------------------------------------------------------");
        }
    }
}
