package it.univpm.Esame.Model;

public class Lavoro {
	private int id;
	private String ruolo;
	private String azienda;
	private String luogo;
	private boolean remoto;
	private String orario;   //part-time o full-time o a contratto
	private String keyword;
	private String data; 
	
	public Lavoro() {
		this.id= 0;
		this.ruolo=null;
		this.azienda=null;
		this.luogo=null;
		this.remoto=false;
		this.data=null;
		this.orario=null;
		this.keyword=null;
	}
	
	
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public String getAzienda() {
		return azienda;
	}
	
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	
	public String getLuogo() {
		return luogo;
	}
	
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public boolean isRemoto() {
		return remoto;
	}
	
	public void setRemoto(boolean remoto) {
		this.remoto = remoto;
	}
	
	public String getOrario() {
		return orario;
	}
	
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
