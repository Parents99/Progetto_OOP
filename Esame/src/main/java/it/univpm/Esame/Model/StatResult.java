package it.univpm.Esame.Model;

import java.util.ArrayList;

public class StatResult {
	private int numTot; //numero totale di annunci
	private int numTotLocation; //numero totale di annunci in una località
	private String fulltimePerc; //percentuale di lavori full time 
	private int numFulltime; //numero di lavori part time
	private String partimePerc; //percentuale di lavori
	private int numPartime;  //numero di lavori part time
	private String contractPerc; //percentuale di lavori a contratto
	private int numContract;
	private ArrayList<String> lan;	 //linguaggi richiesti insieme al javascript
	private String bestJob;  // ruoli più richiesti
	
	public StatResult() {
		this.numTot=0;
		this.numTotLocation=0;
		this.fulltimePerc="";
		this.numFulltime=0;
		this.partimePerc="";
		this.numPartime=0;
		this.contractPerc="";
		this.numContract = 0;
		this.lan=new ArrayList<String>();
		this.bestJob="";
	} 
	
	
	public String getContractPerc() {
		return contractPerc;
	}


	public void setContractPerc(String contractPerc) {
		this.contractPerc = contractPerc;
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


	public void setNumTot(int numTot) {
		this.numTot = numTot;
	}
		
	public int getNumTot() {
		return this.numTot;
	}
	
	public ArrayList<String> getLan() {
		return this.lan;
	}
	
	public void setLan(ArrayList<String> lan) {
		this.lan.addAll(lan);
	}
	
	public String getBestJob() {
		return this.bestJob;
	}
	
	public void setBestJob(String bestJob) {
		this.bestJob = bestJob;
	}
	
	public String getFulltimePerc() {
		return this.fulltimePerc;
	}
	
	public void setFulltimePerc(String fulltimePerc) {
		this.fulltimePerc = fulltimePerc;
	}
	
	public int getNumFulltime() {
		return this.numFulltime;
	}
	
	public void setNumFulltime() {
		this.numFulltime++;
	}
	
	public String getPartimePerc() {
		return this.partimePerc;
	}
	
	public void setPartimePerc(String partimePerc) {
		this.partimePerc = partimePerc;
	}
	
	public int getNumPartime() {
		return this.numPartime;
	}
	
	public void setNumPartime() {
		this.numPartime++;
	}
	
}
