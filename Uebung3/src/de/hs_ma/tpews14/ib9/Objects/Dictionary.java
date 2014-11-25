package de.hs_ma.tpews14.ib9.Objects;

import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Dictionary extends AArray<String, String> {

	public Dictionary(String k,String v){
		super(k,v);
	}
	public Dictionary(){
		super();
	}
	
	public String[] keys (){
		LinkedList <String> list = new LinkedList<>();
		 BiConsumer<String, String> biConsumer = (x, y) -> {
			 list.add(x);
		 };
		 forEach(biConsumer);
		 String[] keyArray = new String[list.size()];
		 return list.toArray(keyArray);
		
	}
	
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
