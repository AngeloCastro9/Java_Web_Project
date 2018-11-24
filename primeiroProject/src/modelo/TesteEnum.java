package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public enum TesteEnum implements Serializable {
	
	ROCK("ROCK"),
	FORRO("FORR�"),
	AXE("AX�")
	;
	
	private String bandas;
	
	TesteEnum(String bandas){
		this.bandas = bandas;
	}
	
	public String getBandas() {
		return bandas;
	}

	
	
}
	
	