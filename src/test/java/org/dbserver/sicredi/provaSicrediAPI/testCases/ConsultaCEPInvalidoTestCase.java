package org.dbserver.sicredi.provaSicrediAPI.testCases;

import org.dbserver.sicredi.provaSicrediAPI.base.ExtentTestManager;
import org.dbserver.sicredi.provaSicrediAPI.base.BuscaDadosAPI;
import org.dbserver.sicredi.provaSicrediAPI.base.TestBase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class ConsultaCEPInvalidoTestCase extends TestBase {

	@Test
	public void ConsultaCEPInvalido() {
		String cep = informacoes.getProperty("cepInvalido");
		ExtentTestManager.log(Status.INFO, "Teste de validacao com o CEP: " + cep);		
		boolean cepInvalido = buscaEndereco.verificaCEPNaAPI(cep);
		Assert.assertEquals(false, cepInvalido);
	}
}
