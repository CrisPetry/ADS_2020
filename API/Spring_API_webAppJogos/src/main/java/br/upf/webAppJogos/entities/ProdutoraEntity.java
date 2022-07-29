package br.upf.webAppJogos.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produtora")
@NamedQueries({
		@NamedQuery(name = "ProdutoraEntity.findByNome", query = "SELECT u FROM ProdutoraEntity u WHERE u.nome = :nome"),
		@NamedQuery(name = "ProdutoraEntity.findByPartNome", query = "SELECT u FROM ProdutoraEntity u WHERE u.nome LIKE :nome") })
public class ProdutoraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private String pais;
	private Integer ano_fundacao;

	public ProdutoraEntity() {

	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getAno_fundacao() {
		return ano_fundacao;
	}

	public void setAno_fundacao(Integer ano_fundacao) {
		this.ano_fundacao = ano_fundacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoraEntity other = (ProdutoraEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
