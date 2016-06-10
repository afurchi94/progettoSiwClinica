package model;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.AmministratoreDaoJpa;
import persist.EsameDaoJpa;
import persist.MedicoDaoJpa;
import persist.PazienteDaoJpa;
import persist.TipologiaEsameDaoJpa;



public class Clinica {
	private List<Amministratore> amministratori;
	private List<TipologiaEsame> tipologieEsame;
	private List<Medico> medici;
	private List<Paziente> pazienti;
	private List<Esame> esami;
	
	public Clinica(EntityManager em){
	// Prendo tutte le liste dal DB con le named Query
		EsameDaoJpa esameDaoJpa = new EsameDaoJpa();
		this.esami=esameDaoJpa.findAll(em);
		MedicoDaoJpa medicoDaoJpa = new MedicoDaoJpa();
		this.medici=medicoDaoJpa.findAll(em);
		PazienteDaoJpa pazienteDaoJpa = new PazienteDaoJpa();
		this.pazienti=pazienteDaoJpa.findAll(em);
		TipologiaEsameDaoJpa tipologiaEsameDaoJpa = new TipologiaEsameDaoJpa();
		this.tipologieEsame=tipologiaEsameDaoJpa.findAll(em);
		
	}
	
	
	
	public void creaTipologia(EntityManager em, TipologiaEsame tipo){
		TipologiaEsameDaoJpa tipologiaDao = new TipologiaEsameDaoJpa();
		tipologiaDao.save(em, tipo);
	}
	
	
	public List<Amministratore> getAmministratori() {
		return amministratori;
	}


	public void setAmministratori(List<Amministratore> amministratori) {
		this.amministratori = amministratori;
	}


	public List<TipologiaEsame> getTipologieEsame() {
		return tipologieEsame;
	}


	public void setTipologieEsame(List<TipologiaEsame> tipologieEsame) {
		this.tipologieEsame = tipologieEsame;
	}


	public List<Medico> getMedici() {
		return medici;
	}


	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}


	public List<Paziente> getPazienti() {
		return pazienti;
	}


	public void setPazienti(List<Paziente> pazienti) {
		this.pazienti = pazienti;
	}


	public List<Esame> getEsami() {
		return esami;
	}


	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}


	public Amministratore cercaAmministratore(EntityManager em,String username){
		
		AmministratoreDaoJpa amministrazioneDao = new AmministratoreDaoJpa();
		Amministratore amministratore = new Amministratore();
		amministratore.setUsername(username);
		
		amministratore = amministrazioneDao.find(em, amministratore);
		return amministratore;
	}
	
	
	public void creaPaziente(EntityManager em, Paziente p){
	
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		pazienteDao.save(em, p);
		
		
	}
	
	
	public Esame cercaEsame(EntityManager em, String codiceEsame){
	

		Esame e= new Esame();
		e.setCodice(codiceEsame);
		
		EsameDaoJpa esameDao = new EsameDaoJpa();
		Esame esame = esameDao.find(em, e);
	
		return esame;
	}
	
	
	public TipologiaEsame cercaTipologia(EntityManager em,String codiceTipologia){
		
		TipologiaEsame tipo= new TipologiaEsame();
		tipo.setCodice(codiceTipologia);
		
		TipologiaEsameDaoJpa tipologiaDao = new TipologiaEsameDaoJpa();
		TipologiaEsame tipologia = tipologiaDao.find(em, tipo);
		
		return tipologia;
	}
	
	public Medico cercaMedico(EntityManager em, String codiceMedico){
		
		Medico m= new Medico();
		m.setCodice(codiceMedico);
		
		MedicoDaoJpa medicoDao = new MedicoDaoJpa();
		Medico medico = medicoDao.find(em,m);
		
		return medico;
	}
	
	public Paziente cercaPaziente(EntityManager em, String codiceFiscale){
		
		Paziente p= new Paziente();
		p.setCodiceFiscale(codiceFiscale);
		
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		Paziente paziente = pazienteDao.find(em,p);
		
		return paziente;
	}
	
}
