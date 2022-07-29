package br.upf.webAppJogos.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.upf.webAppJogos.entities.JogoEntity;

@Repository
public abstract class JogoRepositoryImpl implements JogoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<JogoEntity> findByProdCodigo(Long produtoraCod) {
		List<JogoEntity> entidadeList = new ArrayList<>();
		TypedQuery<JogoEntity> query = em.createNamedQuery("JogoEntity.findByProdCodigo", JogoEntity.class);
		query.setParameter("produtoraCod", produtoraCod);
		entidadeList = query.getResultList();
		return entidadeList;
	}
	
	@Override
	public List<JogoEntity> findByPartTitulo(String titulo) {
		List<JogoEntity> entidadeList = new ArrayList<>();
		TypedQuery<JogoEntity> query = em.createNamedQuery("JogoEntity.findByPartTitulo",
				JogoEntity.class);
		query.setParameter("titulo", titulo);
		entidadeList = query.getResultList();
		return entidadeList;
	}
}
