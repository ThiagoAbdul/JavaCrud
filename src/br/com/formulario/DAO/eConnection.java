package br.com.formulario.DAO;

public enum eConnection {
	PASSWORD("@_XerelTrindade2022"){
		
	};



	private String value;

	private eConnection(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}