package br.com.petshow.enums;

public enum EnumSizePhoto {
	PERFIL(800),
	PERDIDO(800),
	ADOCAO(800);
	
	private int size;
	
	EnumSizePhoto(int size){
		this.size=size;
		
	}
	public int getSize() {
		return size;
	}
}
