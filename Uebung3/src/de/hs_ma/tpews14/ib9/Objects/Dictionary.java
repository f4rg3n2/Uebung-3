package de.hs_ma.tpews14.ib9.Objects;

import java.util.LinkedList;
import java.util.function.BiConsumer;

public class Dictionary extends StringAssociativeArray<String> {

	
	public Dictionary(String k,String v){
		super(k,v);
	}
	
	public Dictionary(){
		super();
	}
	
	/**
	 * Ruft die forEach-Methode auf und fuegt mit Hilfe
	 * des BiConsumers die Schluesses des Baumes einer 
	 * Liste hinzu.
	 * Diese Lise wird dann in ein Array importiert.
	 * 
	 * @return String Array, das die Schluessel enthaelt
	 */
	public String[] keys (){
		LinkedList <String> list = new LinkedList<>();
		 BiConsumer<String, String> biConsumer = (x, y) -> {
			 list.add(x);
		 };
		 forEach(biConsumer);
		 String[] keyArray = new String[list.size()];
		 return list.toArray(keyArray);
		
	}
	
	/**
	 * Gleich wie die keys-Methode nur mit Werten.
	 * 
	 * @return String Array, das die Werte enthaelt
	 */
	public String[] values(){
		LinkedList <String> list = new LinkedList<>();
		 BiConsumer<String, String> biConsumer = (x, y) -> {
			 list.add(y);
		 };
		 forEach(biConsumer);
		 String[] valueArray = new String[list.size()];
		 return list.toArray(valueArray);
		
	}
		
	
}
