package model;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.MedicoDaoJpa;
import persist.PazienteDaoJpa;
import persist.TipologiaEsameDaoJpa;



public class Clinica {
	private List<Amministratore> amministratori;
	private List<TipologiaEsame> tipologieEsame;
	private List<Medico> medici;
	private List<Paziente> pazienti;
	private List<Esame> esami;
	/*
	public Clinica(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		
		emf.close();
		em.close();
	}
	*/
	
	public TipologiaEsame cercaTipologia(String codiceTipologia){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		
		TipologiaEsame tipo= new TipologiaEsame();
		tipo.setCodice(codiceTipologia);
		
		TipologiaEsameDaoJpa tipologiaDao = new TipologiaEsameDaoJpa();
		TipologiaEsame tipologia = tipologiaDao.find(em, tipo);
		
		emf.close();
		em.close();
		return tipologia;
	}
	
	public Medico cercaMedico(String codiceMedico){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		
		Medico m= new Medico();
		m.setCodice(codiceMedico);
		
		MedicoDaoJpa medicoDao = new MedicoDaoJpa();
		Medico medico = medicoDao.find(em,m);
		
		emf.close();
		em.close();
		return medico;
	}
	
	public Paziente cercaPaziente(String codiceFiscale){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		
		Paziente p= new Paziente();
		p.setCodiceFiscale(codiceFiscale);
		
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		Paziente paziente = pazienteDao.find(em,p);
		
		emf.close();
		em.close();
		return paziente;
	}
	
}
