/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prova.entity;

import java.io.Serializable;

/**
 *
 * @author xSandman
 */
public class TbJogo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idJogo;
    private String titulo;
    private String genero;

    public TbJogo() {
    }

    public TbJogo(Integer idJogo, String titulo, String genero) {
        this.idJogo = idJogo;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
