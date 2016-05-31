package model;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQuery(name = "findAllTipologie", query = "SELECT t FROM TipologiaEsame t")
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codice;
	private String nome;
	private String descrizione;
	private double costo;
	@ManyToMany(mappedBy = "tipologie")
	private List<Prerequisito> prerequisiti;
	@OneToMany
	@JoinColumn(name = "tipologiaEsame_fk")
	private List<Risultato> risultati;

	public TipologiaEsame() {
		this.risultati = new LinkedList<>();
		this.prerequisiti = new LinkedList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}

	public void addRisultato(Risultato risultato) {
		this.risultati.add(risultato);
	}
	
	public void addPrerequisito(Prerequisito prerequisito){
		this.prerequisiti.add(prerequisito);
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
		TipologiaEsame other = (TipologiaEsame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipologiaEsame [id=" + id + ", codice=" + codice + ", nome=" + nome + ", descrizione=" + descrizione
				+ ", costo=" + costo + "]";
	}

}
