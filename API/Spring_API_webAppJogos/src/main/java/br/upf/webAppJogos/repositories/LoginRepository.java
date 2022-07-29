package br.upf.webAppJogos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upf.webAppJogos.entities.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

	List<LoginEntity> findByPartNome(String nome);

	LoginEntity findByUsuario(String usuario);
}
