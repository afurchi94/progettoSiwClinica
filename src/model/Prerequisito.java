package model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Prerequisito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codice;
	private String nome;
	private String descrizione;
	@ManyToMany
	private List<TipologiaEsame> tipologie;
	public Long getId() {
		return id;
	}
	
	public Prerequisito(){
		this.tipologie = new LinkedList<>();
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
	
	public List<TipologiaEsame> getTipologie() {
		return tipologie;
	}

	public void setTipologie(List<TipologiaEsame> tipologie) {
		this.tipologie = tipologie;
	}
	public void addTipologiaEsame(TipologiaEsame tipologia){
		this.tipologie.add(tipologia);
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
		Prerequisito other = (Prerequisito) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	
}
