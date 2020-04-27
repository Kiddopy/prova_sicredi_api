package org.dbserver.sicredi.provaSicrediAPI.base;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BuscaDadosAPI {
	
	private Auxi auxi;
	private Properties links;
	
	public BuscaDadosAPI() throws IOException {
		this.auxi = new Auxi();
		this.links = auxi.getProperties("config.properties");	
	}
	
	public Endereco getCEP() {
		return given()
		.contentType(ContentType.JSON)
		.when()
		.get(links.getProperty("api"))
		.then()
		.extract()
		.jsonPath()
        .getObject("$", Endereco.class);
	}
	
	public List<Endereco> getListaDeCEP() {
		List<Endereco> endereco = new ArrayList<Endereco>();
		try {
			return given()
			        .contentType(ContentType.JSON)   
			        .when()
			        .get(links.getProperty("apiExtra"))
			        .then()
			        .extract()
			        .jsonPath()
			        .getList("$", Endereco.class); 			
		}catch(Exception e) {
			return endereco;
		}
	}

	

}
