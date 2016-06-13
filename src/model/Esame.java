package model;

import java.sql.Time;
import java.util.*;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllEsami", query = "SELECT e FROM Esame e")
public class Esame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dataPrenotazione;
	private String effettuato;
	private Time oraPrenotazione;
	@Temporal(TemporalType.DATE)
	private Date dataEffettuazione;
	@OneToOne( fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	private TipologiaEsame tipologia;
	@ManyToOne( fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="paziente_fk")
	private Paziente paziente;
	// ho dovuto mettere per forza eager perche con LAZY mi dava problemi
	@OneToMany( fetch = FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "esame_fk")
	private List<Risultato> risultati;
	@ManyToOne( fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Medico medico;

	
	public Esame(){
		this.effettuato="NO";
	}
	
	
	
	public String getEffettuato() {
		return effettuato;
	}



	public void setEffettuato(String effettuato) {
		this.effettuato = effettuato;
	}



	public Time getOraPrenotazione() {
		return oraPrenotazione;
	}

	public void setOraPrenotazione(Time oraPrenotazione) {
		this.oraPrenotazione = oraPrenotazione;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Date getDataEffettuazione() {
		return dataEffettuazione;
	}

	public void setDataEffettuazione(Date dataEffettuazione) {
		this.dataEffettuazione = dataEffettuazione;
	}

	public TipologiaEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		
		this.risultati = risultati;
		this.medico.addEsame(this);
	
	}

	public void aggiungiPrenotazioneAPaziente(){
		this.paziente.addEsamePrenotato(this);
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!(id==other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esame [id=" + id +", dataPrenotazione=" + dataPrenotazione
				+ ", dataEfettuazione=" + dataEffettuazione + ", tipologia=" + tipologia + ", paziente=" + paziente
				+ "]";
	}

}
