package questionario.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	private String nome;
	@NotNull()
	@Size(min=2,message="cognome richiesto")
	private String cognome;

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

}
