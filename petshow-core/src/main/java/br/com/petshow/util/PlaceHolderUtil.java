package br.com.petshow.util;

public class PlaceHolderUtil {
	
	
	
	private static final String SEL_ESTADO;
	private static final String SEL_CIDADE;
	private static final String SEL_BAIRRO;
	private static final  String SEL_USUARIO;
	private static final  String SEL_ANIMAL;
	private static final  String SEL_SEXO;
	private static final  String SEL_FASE;
	private static final  String SEL_SERVICO;


	static{
		SEL_ESTADO="Selecione um estado";
		SEL_CIDADE="Selecione uma cidade";
		SEL_BAIRRO="Selecione um bairro";
		SEL_USUARIO="Selecione um usuario";
		SEL_ANIMAL="Selecione um tipo de animal";
		SEL_SEXO="Selecione um gênero";
		SEL_FASE="Selecione uma fase";
		SEL_SERVICO="Selecione um servico";
	}



	public static String getSelEstado() {
		return SEL_ESTADO;
	}



	public static String getSelCidade() {
		return SEL_CIDADE;
	}



	public static String getSelBairro() {
		return SEL_BAIRRO;
	}



	public static String getSelUsuario() {
		return SEL_USUARIO;
	}



	public static String getSelAnimal() {
		return SEL_ANIMAL;
	}



	public static String getSelSexo() {
		return SEL_SEXO;
	}



	public static String getSelFase() {
		return SEL_FASE;
	}
	
	public static String getSelServico() {
		return SEL_SERVICO;
	}

}
