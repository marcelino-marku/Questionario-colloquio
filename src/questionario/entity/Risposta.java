package questionario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "risposte")
public class Risposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "testo")
	private String testoRisposta;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_domanda")
	private Domanda domanda;

	public Risposta() {

	}

	public Risposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestoRisposta() {
		return testoRisposta;
	}

	public void setTestoRisposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}


	public Domanda getDomanda() {
		return domanda;
	}

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}

	@Override
	public String toString() {
		return "Risposta [id=" + id + ", testoRisposta=" + testoRisposta + "]";
	}

}
