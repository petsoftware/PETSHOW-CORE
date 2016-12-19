package br.com.petshow.enums;

import br.com.petshow.constants.RestConstants;

public enum EnumPatternREST {

	PATTERN_URL_INSERT(RestConstants.REST_PATTERN_URL_INSERT),
	PATTERN_URL_REMOVE(RestConstants.REST_PATTERN_URL_REMOVE),
	PATTERN_URL_UPDATE(RestConstants.REST_PATTERN_URL_UPDATE),
	PATTERN_URL_GET(RestConstants.REST_PATTERN_URL_GET);
	private final String value;
	EnumPatternREST(String value){
		this.value = value;
	}
	public final String getValue() {
		return value;
	}
	
}
