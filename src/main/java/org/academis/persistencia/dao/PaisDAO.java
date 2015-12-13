package org.academis.persistencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.academis.persistencia.entidade.Pais;

/**
 * Classe de manipulação de dados da tabela <strong>pais</strong> da base de
 * dados do Academis.
 * 
 * @author Rogerio J. Gentil
 *
 */
public class PaisDAO extends AbstractDAO<Pais, Long> {

	public PaisDAO(EntityManager em) {
		super(Pais.class, em);
	}
	
	/**
	 * Obtém um país pela sigla.
	 * 
	 * @param sigla Sigla do país (segundo ISO 3166).
	 * @return Pais
	 */
	public Pais obter(String sigla) {
		Query query = getEntityManager().createNamedQuery("Pais.obterPorSigla");
		query.setParameter("sigla", sigla);
		return (Pais) query.getSingleResult(); 
	}
}