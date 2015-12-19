package org.academis.persistencia.dao;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.academis.persistencia.JPAUtil;
import org.academis.persistencia.entidade.Pais;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste de integração com SGBD da classe PaisDAO.
 * 
 * @author Rogerio J. Gentil
 *
 */
public class PaisDAOTest {

	private Pais pais;
	private PaisDAO paisDAO;
	private EntityManager em;
	private EntityTransaction tx;

	public PaisDAOTest() {
		pais = new Pais();
		pais.setNome("Brasil");
		pais.setSigla("BR");
		pais.setDDI("55");
		pais.setDenominacaoDeNacionalidade("brasileira");
	}

	@Before
	public void antesDeCadaTeste() {
		em = JPAUtil.getEntityManager();		
		
		paisDAO = new PaisDAO(em);
		
		tx = em.getTransaction();
	}
	
	@After
	public void depoisDeCadaTeste() {		
		JPAUtil.fecharEntityManager(em);
	}
	
	@Test
	public void deveTestarCRUD() {
		tx.begin();
		paisDAO.salvar(pais);
		tx.commit();
		
		Pais pais = paisDAO.obterPor(1L);
		assertEquals(1L, pais.getId());
		
		tx.begin();
		pais.setDenominacaoDeNacionalidade("brasileiro");
		paisDAO.atualizar(pais);
		tx.commit();
		
		tx.begin();
		paisDAO.remover(pais);
		tx.commit();
	}
	
	@Test
	public void deveObterUmPaisPelaSigla() {
		tx.begin();
		paisDAO.salvar(pais);
		tx.commit();
		
		Pais pais = paisDAO.obter("BR");
		assertEquals("Brasil", pais.getNome());
	}
}
