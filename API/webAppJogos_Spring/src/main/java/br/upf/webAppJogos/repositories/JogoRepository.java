package br.upf.webAppJogos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upf.webAppJogos.entities.JogoEntity;

public interface JogoRepository extends JpaRepository<JogoEntity, Long> {

	List<JogoEntity> findByProdCodigo(Long produtoraCod);

	List<JogoEntity> findByTitulo(String titulo);

	List<JogoEntity> findByPartTitulo(String titulo);
}
