package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="findAllMedici",query = "SELECT m FROM Medico m")
public class Medico {
	@Id
	private String codice;
	private String nome;
	private String cognome;
	private String specializzazione;
	//con fetch Lazy mi da errore
	@OneToMany(mappedBy="medico", fetch= FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Esame> esami;
             
	public Medico() {
		this.esami = new LinkedList<>();
	}

	

	public String getSpecializzazione() {
		return specializzazione;
	}



	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}



	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public void addEsame(Esame esame) {
		this.esami.add(esame);
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
		Medico other = (Medico) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [codice=" + codice + ", nome=" + nome + ", cognome=" + cognome + ", esami=" + esami + "]";
	}

}
