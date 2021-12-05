package it.univpm.Esame.Model;

import java.util.ArrayList;

public class StatResult {
	private int numTotale; //numero totale di annunci
	private int numTotLocation; //numero totale di annunci in una località
	private String fulltimePercentuale; //percentuale di lavori full time 
	private int numFulltime; //numero di lavori part time
	private String partimePercentuale; //percentuale di lavori
	private int numPartime;  //numero di lavori part time
	private String contractPercentuale; //percentuale di lavori a contratto
	private int numContract; //numero di lavori a contratto
	private int numRemoto;//numero di lavori da remoto
	private String remotoPercentuale; //percentuale di lavori da remoto
	private ArrayList<String> linguaggi;	 //linguaggi richiesti insieme al javascript
	private String bestJob;  // ruoli più richiesti


	public StatResult() {
		this.numTotale=0;
		this.numTotLocation=0;
		this.fulltimePercentuale="";
		this.numFulltime=0;
		this.partimePercentuale="";
		this.numPartime=0;
		this.contractPercentuale="";
		this.numContract = 0;
		this.linguaggi=new ArrayList<String>();
		this.bestJob="";
	} 
	
	public int getNumRemoto() {
		return numRemoto;
	}
	
	public void setNumRemoto() {
		this.numRemoto++;
	}


	public String getRemotoPercentuale() {
		return remotoPercentuale;
	}


	public void setRemotoPercentuale(String remotoPercentuale) {
		this.remotoPercentuale = remotoPercentuale;
	}

	
	public String getContractPerc() {
		return contractPercentuale;
	}


	public void setContractPerc(String contractPercentuale) {
		this.contractPercentuale = contractPercentuale;
	}


	public int getNumContract() {
		return numContract;
	}


	public void setNumContract() {
		this.numContract++;
	}


	public int getNumTotLocation() {
		return numTotLocation;
	}


	public void setNumTotLocation(int numTotLocation) {
		this.numTotLocation = numTotLocation;
	}


	public void setNumTot(int numTotale) {
		this.numTotale = numTotale;
	}
		
	public int getNumTot() {
		return this.numTotale;
	}
	
	public ArrayList<String> getLan() {
		return this.linguaggi;
	}
	
	public void setLan(ArrayList<String> linguaggi) {
		this.linguaggi.addAll(linguaggi);
	}
	
	public String getBestJob() {
		return this.bestJob;
	}
	
	public void setBestJob(String bestJob) {
		this.bestJob = bestJob;
	}
	
	public String getFulltimePerc() {
		return this.fulltimePercentuale;
	}
	
	public void setFulltimePerc(String fulltimePercentuale) {
		this.fulltimePercentuale = fulltimePercentuale;
	}
	
	public int getNumFulltime() {
		return this.numFulltime;
	}
	
	public void setNumFulltime() {
		this.numFulltime++;
	}
	
	public String getPartimePerc() {
		return this.partimePercentuale;
	}
	
	public void setPartimePerc(String partimePercentuale) {
		this.partimePercentuale = partimePercentuale;
	}
	
	public int getNumPartime() {
		return this.numPartime;
	}
	
	public void setNumPartime() {
		this.numPartime++;
	}
	
}
