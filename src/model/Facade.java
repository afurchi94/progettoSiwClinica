package model;

import persist.PazienteDaoJpa;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.*;
import javax.ejb.*;

import persist.*;

import java.util.*;
import java.sql.Time;
import java.time.*;

@Stateless(name="facade")
public class Facade {
	private Clinica clinica;
	private TipologiaEsame tipologiaCorrente;
	private Medico medicoCorrente;
	private Paziente pazienteCorrente;
	private Esame esameCorrente;
	private Amministratore amministratoreCorrente;
	// @PersistenceContext(unitName = "clinicaAcme-unit-tomee")

	public Facade() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		this.clinica = new Clinica(em);
		em.close();
		emf.close();
	}




	public List<Esame> getEsami(){
		return this.clinica.getEsami();
	}
	public List<Medico> getMedici(){
		return this.clinica.getMedici();
	}
	public List<Paziente> getPazienti(){
		return this.clinica.getPazienti();
	}
	public List<TipologiaEsame> getTipologieEsame(){
		return this.clinica.getTipologieEsame();
	}
	
	
	
	public void inserisciRisultatoEsame(Esame e ,String risultato, int i){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		//EsameDaoJpa eJpa= new EsameDaoJpa();
		em.persist(e);
		e.setEffettuato("SI");
		e.getRisultati().get(i).setRisultato(risultato);
				
		//eJpa.update(em, e);
		
	
		tx.commit();
		
		em.close();
		emf.close();
	
	}

	public Medico selezionaMedico(String codice){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		Medico m= this.clinica.cercaMedico(em, codice);
		this.medicoCorrente=m;
		em.close();
		emf.close();
		return m;
	}

	public Esame scegliEsame(String codice) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		Esame e= this.clinica.cercaEsame(em,codice);
		this.esameCorrente=e;
		em.close();
		emf.close();
		return e;
	}




	public void inserisciDatiEsame(String nomeTipo, String codFisc, Date dataE, String codMedico ){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
	
		
		String codTipo="";
		for(TipologiaEsame tipologia : this.clinica.getTipologieEsame()){
			if(tipologia.getNome().equals(nomeTipo) )
				codTipo = tipologia.getCodice();
		}
		
		
		TipologiaEsame t= clinica.cercaTipologia(em,codTipo);
		this.tipologiaCorrente=t;
		Medico m= clinica.cercaMedico(em,codMedico);
		this.medicoCorrente=m;
		Paziente p= clinica.cercaPaziente(em,codFisc);
		this.pazienteCorrente=p;


		Esame esame= new Esame();
		
		esame.setDataEffettuazione(dataE);
		esame.setPaziente(p);
		esame.setMedico(m);
		esame.setTipologia(t);
		
		//creo la lista dei risultati per l'esame basandoci su quelli della tipologia scelta
		List<Risultato> risultati = new LinkedList<Risultato>();
		for(int i=0; i< t.getRisultati().size(); i++){
			Risultato ris=new Risultato();
			ris.setNome(t.getRisultati().get(i).getNome());
			RisultatoDaoJpa risultatoDao = new RisultatoDaoJpa();
			risultatoDao.save(em, ris);
			risultati.add(ris);
		
		}
		esame.setRisultati(risultati);
		
		LocalDate data= java.time.LocalDate.now() ;
		Date dataP= Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
		esame.setDataPrenotazione(dataP);
		int ora=java.time.LocalDateTime.now().getHour();
		int minuti=java.time.LocalDateTime.now().getMinute();
		int secondi= java.time.LocalDateTime.now().getSecond();
		@SuppressWarnings("deprecation")
		Time time= new Time(ora,minuti,secondi);
		esame.setOraPrenotazione(time);

		
		esame.aggiungiPrenotazioneAPaziente();
		PazienteDaoJpa pazienteDao = new PazienteDaoJpa();
		pazienteDao.update(em, esame.getPaziente());
		
		EsameDaoJpa esameDao = new EsameDaoJpa();
		esameDao.save(em, esame);
		
		this.esameCorrente=esame;
		
		
		em.close();
		emf.close();
	}


	public TipologiaEsame scegliTipologiaEsame(String codiceTipologia){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		TipologiaEsame t = this.clinica.cercaTipologia(em,codiceTipologia);
		this.tipologiaCorrente=t;
		em.close();
		emf.close();

		return t;
	}


	public void inserisciPaziente(Paziente paziente) {
		this.pazienteCorrente=paziente;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		this.clinica.creaPaziente(em, paziente);
		em.close();
		emf.close();
	}



	public void inserisciTipologiaEsame(TipologiaEsame tipologia, List<String> risultati, List <String> preRequisiti) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		
		
		// ricerca prerequisito tramite nome
		List<Prerequisito> listReq=  new LinkedList<Prerequisito>();
		for(int i=0; i<preRequisiti.size(); i++){
			Prerequisito p=new Prerequisito();
			p.setNome(preRequisiti.get(i));
			PrerequisitoDaoJpa pDaoJpa= new PrerequisitoDaoJpa();
			Prerequisito preRequisito= pDaoJpa.find(em, p);
			if(!listReq.contains(preRequisito))
			listReq.add(preRequisito);
		}

		// salvataggio del risultato nel database.


		List<Risultato> listRis=  new LinkedList<Risultato>();
		for(int i=0; i<risultati.size();i++){
			Risultato r=new Risultato();
			r.setNome(risultati.get(i));
			RisultatoDaoJpa risultatoDao = new RisultatoDaoJpa();
			risultatoDao.save(em, r);
			
			if(!listRis.contains(r))
			listRis.add(r);
		}

		// aggiunta del prerequisito alla tipologia di esame

		tipologia.setPrerequisiti(listReq);
		tipologia.setRisultati(listRis);
		// inserimento tipologia esame

		this.clinica.creaTipologia(em, tipologia);
		
		em.close();
		emf.close();
	}

	public Amministratore loginAmministrazione(String username, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		Amministratore amministratore = this.clinica.cercaAmministratore(em,username);
		if (amministratore != null)
			if (amministratore.checkPassword(password)){
				em.close();
				emf.close();
				this.amministratoreCorrente=amministratore;
				return amministratore;
			}
		em.close();
		emf.close();
		return null;
	}

	public Paziente loginPaziente(String codiceFiscale, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();
		Paziente paziente = this.clinica.cercaPaziente(em,codiceFiscale);
		if (paziente != null)
			if (paziente.checkPassword(password)){
				em.close();
				emf.close();
				this.pazienteCorrente=paziente;
				return paziente;
			}
		em.close();
		emf.close();
		return null;
	}


	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaAcme-unit");
		EntityManager em = emf.createEntityManager();

		TipologiaEsame tipologia = new TipologiaEsame();
		tipologia.setCodice("001");
		tipologia.setNome("TAC");
		tipologia.setDescrizione("Ti fanno una normale TAC");
		tipologia.setCosto(99.90);
		
		List<String> preRequisiti= new LinkedList<String>();
		List<String> risultati= new LinkedList<String>();
		preRequisiti.add("maggiorenne");
		preRequisiti.add("incinta");
		
		risultati.add("emorragie");
		risultati.add("ischemie");
		risultati.add("tumori");
		
		
		Facade facade = new Facade();
		facade.inserisciTipologiaEsame(tipologia, risultati, preRequisiti);
		
	
		em.close();
		emf.close();
	}
}
