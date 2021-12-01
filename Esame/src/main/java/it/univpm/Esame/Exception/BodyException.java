package it.univpm.Esame.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class BodyException extends Exception{
	//eccezione 
	
	public BodyException() {	
		super();
	}
	
	public void InvalidBody(String out) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,out);
	}
	
	public void BodyResults(String out) {
		throw new ResponseStatusException(HttpStatus.OK, out);
	}

}
