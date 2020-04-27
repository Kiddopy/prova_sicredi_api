package org.dbserver.sicredi.provaSicrediAPI.base;

import java.io.IOException;
import java.util.List;

import com.aventstack.extentreports.Status;

public class BuscaDeEnderecos {
	
	public BuscaDadosAPI buscaDados;
	public Auxi auxi;
	
	public BuscaDeEnderecos() throws IOException {
		this.buscaDados  = new BuscaDadosAPI();
		this.auxi = new Auxi();
	}
	
	public boolean verificaCEPNaAPI(String cep) {
	    if(auxi.padraoValidoDeCEP(cep)) {
	    	Endereco endereco = buscaDados.getCEP();
	 	    boolean enderecoCorreto = enderecoCorreto(endereco, cep);
	 	    if(enderecoCorreto)
	 	    	return true;
	 	    ExtentTestManager.log(Status.INFO, "CEP não encontrado!");
	 	}else {
	 		ExtentTestManager.log(Status.INFO, "CEP incorreto!");		
	 	}
		return false;
	}
	    
	
//	public boolean procuraCEPNaListaDaAPI(String cep) {
//		boolean cepEncontrado = false;
//		if(auxi.padraoValidoDeCEP(cep)) {
//			List<Endereco> enderecos = httpsValidations.getListaDeCEP();
//			for(Endereco endereco : enderecos) {
//				boolean enderecoCorreto = enderecoCorreto(endereco, cep);
//				if(enderecoCorreto)
//					return true;
//			}
//			if(!cepEncontrado)
//				ExtentTestManager.log(Status.FAIL, "CEP não encontrado!");			
//		}else {
//			ExtentTestManager.log(Status.FAIL, "CEP incorreto!");	
//		}
//		return false;
//	}
	
	public void retornaResultadosDaAPI() {
		List<Endereco> enderecos = buscaDados.getListaDeCEP();
		String textoParaReport = "";
		for(Endereco endereco : enderecos) {
			textoParaReport += textoDeEnderecoParaHTML(endereco);
			textoParaReport += "<br />  ----- <br/>";
		}
		ExtentTestManager.log(Status.PASS, textoParaReport);
	}
	
	private boolean enderecoCorreto(Endereco endereco, String cep) {
		if(endereco.cep.contentEquals(cep)) {
			String mensagemDoReport = textoDeEnderecoParaHTML(endereco);
 	    	ExtentTestManager.log(Status.INFO, mensagemDoReport);
 	    	return true;
		}	
		return false;
	}
	
	private String textoDeEnderecoParaHTML(Endereco endereco) {
		return "CEP:" + endereco.cep + "<br/>"
	    			+ "Logradouro: " + endereco.logradouro + "<br/>"
	    			+ "Complemento: " + endereco.complemento + "<br/>"
	    			+ "Bairro: " + endereco.bairro + "<br/>"
	    			+ "Localidade: " + endereco.localidade + "<br/>"
	    			+ "UF: " + endereco.uf + "<br/>"
	    			+ "IBGE: " + endereco.ibge + "<br/>"; 
	}

}
