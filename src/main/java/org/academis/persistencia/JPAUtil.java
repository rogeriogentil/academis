package org.academis.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("academis_PU");

	private JPAUtil() {
	}

	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

	public static void fecharEntityManager(EntityManager em) {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}
}
