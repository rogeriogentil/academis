package org.academis.persistencia.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.websocket.Session;

/**
 * Classe de abstração de acesso aos dados da base de dados do Academis.
 * 
 * @author Rogerio J. Gentil
 *
 */
public abstract class AbstractDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private final Class<T> entidade;
	private final EntityManager em;

	public AbstractDAO(Class<T> entidade, EntityManager em) {
		this.entidade = entidade;
		this.em = em;
	}

	@Override
	public void salvar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public T obterPor(ID id) {
		return em.find(entidade, id);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(T entidade) {
		em.remove(entidade);
	}

	protected EntityManager getEntityManager() {
		return this.em;
	}

	protected Session getSession() {
		return this.getEntityManager().unwrap(Session.class);
	}
}
