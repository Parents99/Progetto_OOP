package it.univpm.Esame.Model;

import java.util.ArrayList;

	/**
	 * Rappresenta la classe per le statistiche degli annunci.
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */

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
	private String bestJob;  // ruoli più richiesti
	private ArrayList<String> linguaggi;	 //linguaggi richiesti insieme al javascript

	/**
	 * Costruttore senza parametri
	 */
	
	public StatResult() {
		this.numTotale=0;
		this.numTotLocation=0;
		this.fulltimePercentuale="";
		this.numFulltime=0;
		this.partimePercentuale="";
		this.numPartime=0;
		this.contractPercentuale="";
		this.numContract = 0;
		this.bestJob="";
		this.linguaggi=new ArrayList<String>();
	}

	/**
	 * Metodi Getter, Setter di numTotale, numTotLocation, fulltimePercentuale, numFulltime, partimePercentuale, numPartime, 
	 * contractPercentuale, numContract, bestjob, linguaggi
	 */
	
	public int getNumTotale() {
		return numTotale;
	}


	public void setNumTotale(int numTotale) {
		this.numTotale = numTotale;
	}


	public int getNumTotLocation() {
		return numTotLocation;
	}


	public void setNumTotLocation(int numTotLocation) {
		this.numTotLocation = numTotLocation;
	}


	public String getFulltimePercentuale() {
		return fulltimePercentuale;
	}


	public void setFulltimePercentuale(String fulltimePercentuale) {
		this.fulltimePercentuale = fulltimePercentuale;
	}


	public int getNumFulltime() {
		return numFulltime;
	}


	public void setNumFulltime() {
		this.numFulltime++;
	}


	public String getPartimePercentuale() {
		return partimePercentuale;
	}


	public void setPartimePercentuale(String partimePercentuale) {
		this.partimePercentuale = partimePercentuale;
	}


	public int getNumPartime() {
		return numPartime;
	}


	public void setNumPartime() {
		this.numPartime++;
	}


	public String getContractPercentuale() {
		return contractPercentuale;
	}


	public void setContractPercentuale(String contractPercentuale) {
		this.contractPercentuale = contractPercentuale;
	}


	public int getNumContract() {
		return numContract;
	}


	public void setNumContract() {
		this.numContract++;
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

	public String getBestJob() {
		return bestJob;
	}


	public void setBestJob(String bestJob) {
		this.bestJob = bestJob;
	}

	public ArrayList<String> getLinguaggi() {
		return linguaggi;
	}


	public void setLinguaggi(ArrayList<String> linguaggi) {
		this.linguaggi = linguaggi;
	}

}
	
	