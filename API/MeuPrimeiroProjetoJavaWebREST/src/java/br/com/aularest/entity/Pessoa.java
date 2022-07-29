/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aularest.entity;

import java.io.Serializable;
import javax.persistence.Id;

public class Pessoa implements Serializable {

    @Id
    private Integer id;
    private String nome;
    private Integer idade;
    private String cidade;
    private String mensagem;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, Integer idade, String cidade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", cidade=" + cidade + ", mensagem=" + mensagem + '}';
    }
}
