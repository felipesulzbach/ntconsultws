package br.com.ntconsultws.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "SampleService", targetNamespace = "http://service.ntconsultws.com.br")
public class SampleService {

	@WebMethod(operationName = "dizerOla")
	@WebResult(name = "retornoMensagem")
	public String dizerOla(@WebParam(name = "nome") String nome) {
		return String.format("Ola, %s", nome);
	}
}
