package br.upf.webAppJogos.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.upf.webAppJogos.entities.LoginEntity;

@Repository
public abstract class LoginRepositoryImpl implements LoginRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<LoginEntity> findByPartNome(String nome) {
		List<LoginEntity> entidadeList = new ArrayList<>();
		TypedQuery<LoginEntity> query = em.createNamedQuery("LoginEntity.findByPartNome", LoginEntity.class);
		query.setParameter("nome", nome);
		entidadeList = query.getResultList();
		return entidadeList;
	}
}
