package de.hs_ma.tpews14.ib9.Interface;

public interface AssociativeArray <K,V> {

	public void clear();
	public boolean containsValue(V v);
	public boolean containsKey(K k);
	public K get(V v);
	public boolean isEmpty();
	public void put(K k, V v);
	public void putAll();//noch kein Plan
	public void remove (K v);
	public int size();
	public void update();
	public void forEach(BiConsumer <K,V> b);
	public void extractAll();//noch kein Plan
	public void map(BiConsumer<K, V> b);
}
