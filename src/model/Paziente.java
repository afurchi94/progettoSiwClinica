package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllPazienti", query = "SELECT p FROM Paziente p")
public class Paziente {
	@Id
	private String codiceFiscale;
	private String password;
	private String nome;
	private String cognome;
	private Date dataNascita;
	
	// problema del doppio riferimento.
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pazientePrenotato_id")
	private List<Esame> esamiPrenotati;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pazienteEffettuato_id")
	private List<Esame> esamiEffettuati;

	public Paziente() {
		this.esamiPrenotati = new LinkedList<>();
		this.esamiEffettuati = new LinkedList<>();
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public List<Esame> getEsamiPrenotati() {
		return esamiPrenotati;
	}

	public void setEsamiPrenotati(List<Esame> esamiPrenotati) {
		this.esamiPrenotati = esamiPrenotati;
	}

	public void addEsamePrenotato(Esame esame) {
		this.esamiPrenotati.add(esame);
	}

	public List<Esame> getEsamiEffettuati() {
		return esamiEffettuati;
	}

	public void setEsamiEffettuati(List<Esame> esamiEffettuati) {
		this.esamiEffettuati = esamiEffettuati;
	}

	public void addEsameEffettuato(Esame esame) {
		this.esamiEffettuati.add(esame);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
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
		Paziente other = (Paziente) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		return true;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

}
