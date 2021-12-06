package it.univpm.Esame.Model;

import org.springframework.stereotype.Service;

@Service
public class TipsClass {
	
	private String titolo;
	private String citta;
	
	public TipsClass() {
		this.setTitolo("Città americane suggerite :");
		this.setCitta("Plano, Seattle, Brooklyn Park, Palo Alto, Philadelphia");
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public String getCitta() {
		return this.citta;
	}
	
	
}
