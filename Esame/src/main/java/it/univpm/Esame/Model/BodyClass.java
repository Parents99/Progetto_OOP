package it.univpm.Esame.Model;

//classe per request sui filtri
//ci metto solo i campi che ci servono per i filtri

public class BodyClass {
	private String location;  //filtro su città
	private Boolean remoto;  //filtro su lavori in remoto
	private String orario;	//filtro per part-time full-time
	private String ruolo; //filtro sui ruoli
	private String data;  //per filtrare su data
	
	

	public BodyClass(String location, Boolean remoto, String orario, String ruolo, String data) {
		this.location = location;
		this.remoto = remoto;
		this.orario = orario;
		this.ruolo = ruolo;
		this.data = data;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getRemoto() {
		return remoto;
	}

	public void setRemoto(Boolean remoto) {
		this.remoto = remoto;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	

}
