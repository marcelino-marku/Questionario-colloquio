package questionario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "tag")
	private String testo;

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JoinTable(name = "domande_e_tag", 
			joinColumns = @JoinColumn(name = "id_tag"),
			inverseJoinColumns = @JoinColumn(name = "id_domanda"))
	private List<Domanda> domande = new ArrayList<>();

	public Tag() {

	}

	public Tag(String testo) {

		this.testo = testo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public List<Domanda> getDomande() {
		return domande;
	}

	public void setDomande(List<Domanda> domande) {
		this.domande = domande;
	}

}
