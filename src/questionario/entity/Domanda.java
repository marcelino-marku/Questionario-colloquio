package questionario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "domanda")
public class Domanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "testo")
	private String testoDomanda;
	
	
	@Column(name = "difficolta")
	private int difficolta;

	@OneToMany(targetEntity=Risposta.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_domanda")
	private List<Risposta> risposte = new ArrayList<Risposta>();
	
	
	
	@ManyToMany(targetEntity= Tag.class,
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@JoinTable(name="domande_e_tag",
			joinColumns= @JoinColumn(name="id_domanda"),
			inverseJoinColumns = @JoinColumn(name="id_tag")	)
	private List<Tag> tags = new ArrayList<>();
	

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setRisposte(List<Risposta> risposte) {
		this.risposte = risposte;
	}

	public List<Risposta> getRisposte() {
		return risposte;
	}

	public void addRisposta(Risposta risposta) {
		this.risposte.add(risposta);
		risposta.setDomanda(this);
	}
	
	public void removeRisposta(Risposta risposta) {
		this.risposte.remove(risposta);
		risposta.setDomanda(null);
	}


	public Domanda() {

	}

	public Domanda(String testoDomanda, int difficolta) {
		this.testoDomanda = testoDomanda;
		this.difficolta = difficolta;
	}


	public int getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(int difficolta) {
		this.difficolta = difficolta;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTestoDomanda() {
		return testoDomanda;
	}

	public void setTestoDomanda(String testoDomanda) {
		this.testoDomanda = testoDomanda;
	}

}
