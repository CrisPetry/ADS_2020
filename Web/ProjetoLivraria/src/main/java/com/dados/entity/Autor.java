package com.dados.entity;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;

/**
 *
 * @author xSandman
 */
@Entity(value = "Autor", noClassnameStored = true)
public class Autor {

    @Id
    private Integer id;

    @Indexed
    private String nome;

    @Indexed
    private Integer idade;

    public Autor() {
        super();
    }

    public Autor(Integer id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
