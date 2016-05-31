package model;

import javax.persistence.*;

@Entity
public class Amministratore {
	@Id
	private String username;
	private String password;
	private String codice;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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
		Amministratore other = (Amministratore) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public void setPassoword(String password) {
		this.password = password;
	}

}
