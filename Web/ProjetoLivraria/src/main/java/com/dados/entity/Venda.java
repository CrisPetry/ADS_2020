package com.dados.entity;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xSandman
 */
@Entity(value = "Venda", noClassnameStored = true)
public class Venda {

    @Id
    private int id;

    @Indexed
    private Double preco;

    @Embedded("Livro")
    private List<Livro> livros = new ArrayList<Livro>();

   
    public Venda() {
        super();
    }

    public Venda(int id, Double preco) {
        this.id = id;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
