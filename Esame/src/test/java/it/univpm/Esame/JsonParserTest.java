package it.univpm.Esame;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.Esame.Model.Lavoro;

class JsonParserTest {
	private JSONObject json=null;
	private ArrayList<Lavoro> list=null;
	String data=null;
	
	@BeforeEach
	void setUp() {
		
		//data=new String("{"employment_type":"null","date_posted":"2021-12-07T03:14:09Z","role":"Product Engineer","keywords":["qa","sql","javascript","ux"],"comapny_name":"Recyclist","location":"null","id":101094}")
		json=new JSONObject(data);
	}

	@Test
	void test() {
		
	}

}
