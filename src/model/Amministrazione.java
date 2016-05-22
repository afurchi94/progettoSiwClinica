package model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@NamedQuery(name ="findAllAmministrazione",query = "SELECT a FROM Amministrazione a")
public class Amministrazione {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codice;
	private String password;

	public Long getCodice() {
		return codice;
	}

	public void setCodice(Long codice) {
		this.codice = codice;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		Amministrazione other = (Amministrazione) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

}
