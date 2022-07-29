package com.dados.entity;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Reference;
import java.util.ArrayList;

/**
 *
 * @author xSandman
 */
@Entity(value = "Livro", noClassnameStored = true)
public class Livro {

    @Id
    private int id;

    @Indexed
    private String titulo;
    private String ano;
    private String editora;
    
    @Reference
    private Autor autor;

    public Livro() {
        super();
    }

    public Livro(int id, String titulo, String ano, String editora, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.autor = autor;
    }


    public Livro(int id, String titulo, String ano, String editora) {
       this.id = id;
       this.titulo = titulo;
       this.ano = ano;
       this.editora = editora;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
