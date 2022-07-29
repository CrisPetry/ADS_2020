package br.upf.webAppJogos.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.upf.webAppJogos.entities.ProdutoraEntity;

@Repository
public abstract class ProdutoraRepositoryImpl implements ProdutoraRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ProdutoraEntity> findByPartNome(String nome) {
		List<ProdutoraEntity> entidadeList = new ArrayList<>();
		TypedQuery<ProdutoraEntity> query = em.createNamedQuery("ProdutoraEntity.findByPartNome",
				ProdutoraEntity.class);
		query.setParameter("nome", nome);
		entidadeList = query.getResultList();
		return entidadeList;
	}
}
