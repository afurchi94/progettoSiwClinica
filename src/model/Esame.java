package model;

import java.util.*;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllEsami", query = "SELECT e FROM Esame e")
public class Esame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codice;
	private Date dataPrenotazione;
	private Date dataEffettuazione;
	@OneToOne
	@JoinColumn(name="tipologia_fk")
	private TipologiaEsame tipologia;
	@OneToOne
	@JoinColumn(name="paziente_fk")
	private Paziente paziente;
	@OneToMany
	@Column(name = "esame_fk")
	private List<Risultato> risultati;
	@OneToOne
	private Medico medico;

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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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
	}

	public void aggiungiPrenotazioneAPaziente(){
		this.paziente.addEsamePrenotato(this);
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
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
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esame [id=" + id + ", codice=" + codice + ", dataPrenotazione=" + dataPrenotazione
				+ ", dataEfettuazione=" + dataEffettuazione + ", tipologia=" + tipologia + ", paziente=" + paziente
				+ "]";
	}

}
