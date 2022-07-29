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
@Entity(value = "Usuario", noClassnameStored = true)
public class Usuario {

    @Id
    private Integer id;

    @Indexed
    private String nome;

    @Indexed
    private String cpf;
    
    @Embedded("Venda")
    private List<Venda> vendas = new ArrayList<Venda>();


    public Usuario() {
        super();
    }

    public Usuario(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Usuario(List<Usuario> obterUsuarioPorNome) {
        
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

     public List<Venda> getVenda() {
        return vendas;
    }

    public void setVenda(List<Venda> vendas) {
        this.vendas = vendas;
    }


}
