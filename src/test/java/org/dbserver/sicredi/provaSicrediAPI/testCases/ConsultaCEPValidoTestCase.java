package org.dbserver.sicredi.provaSicrediAPI.testCases;


import org.dbserver.sicredi.provaSicrediAPI.base.ExtentTestManager;
import org.dbserver.sicredi.provaSicrediAPI.base.BuscaDadosAPI;
import org.dbserver.sicredi.provaSicrediAPI.base.TestBase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;


public class ConsultaCEPValidoTestCase extends TestBase {
	
	
	@Test
	public void testaCEPvalido() {
		String cep = informacoes.getProperty("cepValido");
		ExtentTestManager.log(Status.INFO, "Teste de validacao com o CEP: " + cep);
		
		boolean cepEncontrado = buscaEndereco.verificaCEPNaAPI(cep);
		Assert.assertEquals(true, cepEncontrado);
		
		
	}


}
