package org.academis.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DDL {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("academis_PU");
		} finally {
			if (emf != null) {
				emf.close();
			}
		}
		
	}

}
