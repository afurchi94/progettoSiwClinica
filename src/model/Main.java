package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.EsameDaoJpa;
import persist.MedicoDaoJpa;
import persist.PazienteDaoJpa;
import persist.TipologiaEsameDaoJpa;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		

		MedicoDaoJpa medicoDao = new MedicoDaoJpa();
		
		System.out.println(medicoDao.findAll(em));
		em.close();
		emf.close();
	}
}
