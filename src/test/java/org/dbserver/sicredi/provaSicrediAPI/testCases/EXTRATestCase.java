package org.dbserver.sicredi.provaSicrediAPI.testCases;

import org.dbserver.sicredi.provaSicrediAPI.base.ExtentTestManager;
import org.dbserver.sicredi.provaSicrediAPI.base.TestBase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class EXTRATestCase extends TestBase {
	
	@Test
	public void RetornaInformacoesDaAPI() {
		
		ExtentTestManager.log(Status.INFO, "Teste de validacao do retorno da API");
		buscaEndereco.retornaResultadosDaAPI();
	}

}
