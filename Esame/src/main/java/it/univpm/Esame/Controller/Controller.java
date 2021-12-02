package it.univpm.Esame.Controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.Esame.Database.Database;
import it.univpm.Esame.Filters.Filters;
import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.TipsClass;
import it.univpm.Esame.Service.JsonParser;






@RestController
public class Controller {
	
	@Autowired
	JsonParser lavoro;
	@Autowired
	Filters filters;
	@Autowired
	TipsClass tips;
	
	
	@GetMapping(value ="/annunci")
	public ResponseEntity<Object> ShowJobs() throws IOException{
		return new ResponseEntity<>(lavoro.Parsing(), HttpStatus.OK);
	}
	
	@GetMapping(value="/tips")
	public TipsClass ShowTips() {
		return new TipsClass();
	}
	
	@PostMapping(value="/filters")
	public ResponseEntity<Object> ShowFilters(@RequestBody it.univpm.Esame.Model.RequestBody body) throws IOException{
		return new ResponseEntity<>(filters.Filter(body),HttpStatus.OK);
	}
	
}
