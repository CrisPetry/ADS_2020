package br.upf.webAppJogos.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jogo")
@NamedQueries({
		@NamedQuery(name = "JogoEntity.findByTitulo", query = "SELECT j FROM JogoEntity j WHERE j.titulo = :titulo"),
		@NamedQuery(name = "JogoEntity.findByProdCodigo", query = "SELECT j FROM JogoEntity j WHERE j.produtora.codigo = :produtoraCod"),
		@NamedQuery(name = "JogoEntity.findByPartTitulo", query = "SELECT j FROM JogoEntity j WHERE j.titulo LIKE :titulo") })
public class JogoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String genero;
	private Integer ano;
	private Float preco;

	@ManyToOne
	@JoinColumn(name = "produtora_cod")
	private ProdutoraEntity produtora;

	public JogoEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public ProdutoraEntity getProdutora() {
		return produtora;
	}

	public void setProdutora(ProdutoraEntity produtora) {
		this.produtora = produtora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEntity other = (JogoEntity) obj;
		return Objects.equals(id, other.id);
	}

}
