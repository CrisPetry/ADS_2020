package br.upf.webAppJogos.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upf.webAppJogos.entities.ProdutoraEntity;

@Transactional
public interface ProdutoraRepository extends JpaRepository<ProdutoraEntity, Long> {

	ProdutoraEntity findByNome(String nome);

	List<ProdutoraEntity> findByPartNome(String nome);

	void deleteByCodigo(Long codigo);
}
