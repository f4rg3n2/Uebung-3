package de.hs_ma.tpews14.ib9.Interface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public interface AssociativeArray <K,V> {

		public void clear();
		public boolean containsValue(V v);
		public boolean containsKey(K k);
		public V get(K k);
		public boolean isEmpty();
		public void put(K k, V v);
		public void putAll(K[] k);//noch kein Pla
		public V remove (K v);
		public int size();
		public void update(K k,V v);
		public void forEach(BiConsumer <K,V> b);
		public void extractAll(K[]k);//noch kein Plan
		public void map(BiFunction<K, V> b);
	}
