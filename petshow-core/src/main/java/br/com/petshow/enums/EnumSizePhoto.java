package br.com.petshow.enums;

public enum EnumSizePhoto {
	PERFIL(1000),
	PERDIDO(1000),
	ADOCAO(1000);
	
	private int size;
	
	EnumSizePhoto(int size){
		this.size=size;
		
	}
	public int getSize() {
		return size;
	}
}
