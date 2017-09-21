package br.com.petshow.enums;

public enum EnumFaseVida {
	FILHOTE("FILHOTE",0), ADULTO("ADULTO",1),IDOSO("IDOSO",2);
		
	
	private int id;
	
	
	
	
	public int getId() {
		return id;
	}

	private String fase;

	EnumFaseVida(String fase,int i) {
		this.fase = fase;
		this.id=i;
	}  

	 public String toString() {
		 return fase;
	}
	 
	 public static int getId(EnumFaseVida enumFase){

			int retorno = 0;
			int contador=0;
			for(EnumFaseVida e : values()) {
				++contador;
				if(e.toString().equals(enumFase.toString())){
					retorno=contador;
				}
			}
			return retorno;


		}
	 
		public static EnumFaseVida getEnum(String descricao){
			for(EnumFaseVida e : values()) {
				
				if(e.toString().equals(descricao)){
					return e;
				}
			}
			return null;
			
		}
}


