package it.univpm.Esame.Model;

import org.springframework.stereotype.Service;

@Service
public class TipsClass {
	
	private String titolo;
	private String città;
	
	public TipsClass() {
		this.setTitolo("Città americane suggerite :");
		this.setCittà("Plano, Seattle, Brooklyn Park, Palo Alto, Philadelphia");
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setCittà(String città) {
		this.città = città;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public String getCittà() {
		return this.città;
	}
	
	
}
