package org.academis.persistencia.dao;

import java.io.Serializable;

/**
 * Interface padrão com declaração dos métodos que devem ser implementados pelas
 * classes DAO da base de dados do Academis.
 *
 * @author Rogerio J. Gentil
 *
 * @param <T> Entidade
 * @param <ID> Tipo de ID da entidade
 */
public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * Persiste uma entidade.
	 * 
	 * @param entidade Entidade
	 */
	void salvar(T entidade);

	/**
	 * Obtém uma entidade pelo ID.
	 * 
	 * @param id Identificador da entidade
	 */
	T obterPor(ID id);

	/**
	 * Atualiza uma entidade.
	 * 
	 * @param entidade Entidade
	 */
	void atualizar(T entidade);

	/**
	 * Remove uma entidade.
	 * 
	 * @param entidade Entidade
	 */
	void remover(T entidade);
}
