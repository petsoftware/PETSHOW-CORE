package br.com.petshow.util;

import javax.ws.rs.core.Response;

import br.com.petshow.enums.EnumErrosSistema;
import br.com.petshow.exceptions.ExceptionValidation;

public class RestUtil {

	public static Response getResponseValidationErro(ExceptionValidation ex){
		ex.printStackTrace();
		return getResponseValidationErro(ex.getMessage());
	}
	
	public static Response getResponseValidationErro(String mensagem){
		return Response.status(Response.Status.BAD_REQUEST).entity(new MapErroRetornoRest(EnumErrosSistema.ERRO_VALIDACAO, mensagem)).build();
	} 
	
	
	public static Response getResponseErroInesperado(Throwable ex){
		ex.printStackTrace();
		return getResponseValidationErro(ex.getMessage());
	}
	
	public static Response getResponseErroInesperado(String mensagem){
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new MapErroRetornoRest(EnumErrosSistema.ERRO_INESPERADO,mensagem)).build();
	}
}
