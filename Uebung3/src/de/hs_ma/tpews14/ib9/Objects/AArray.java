<<<<<<< HEAD
package de.hs_ma.tpews14.ib9.Objects;

import de.hs_ma.tpews14.ib9.Interface.AssociativeArray;
import de.hs_ma.tpews14.ib9.Interface.BiConsumer;

public class AArray <K,V> implements AssociativeArray<K, V> {
 
 Node root;
 public AArray() {
  this.root = null;
 }

 public AArray(K k, V v){
  root = new Node(k, v, null, null);
  
 }
 
 @Override
 public void clear() {
  // TODO Auto-generated method stub
  
 }

 @Override
 public boolean containsValue(V v) {
  // TODO Auto-generated method stub
  return false;
 }

 @Override
 public boolean containsKey(K k) {
  // TODO Auto-generated method stub
  return false;
 }

 @Override
 public K get(V v) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public boolean isEmpty() {
  // TODO Auto-generated method stub
  return root == null;
 }

 @Override
 public void put(K k, V v) {
	 //Problem wegen k
	 if ( < root.getKey()){
		 
	 }
  
 }

 @Override
 public void putAll(K[] k) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void remove(K v) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public int size() {
  // TODO Auto-generated method stub
  return 0;
 }

 @Override
 public void update() {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void forEach(BiConsumer<K, V> b) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void extractAll(K[] k) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void map(BiConsumer<K, V> b) {
  // TODO Auto-generated method stub
  
 }
 public AArray<K,V> getLeftTree() {
		AArray<K,V> a = new AArray<K,V>();
		a.root = root.left;
		return a;
	}

	// linken Unterbaum setzen
	public void setLeft(AArray <K,V> a ) {
		root.left = a.root;
	}

	public AArray<K,V> getRightTree() {
		AArray<K,V> a = new AArray<K,V>();
		a.root = root.right;
		return a;
	}

	public void setRight(AArray <K,V> a) {
		root.right = a.root;
	}

 
 class Node{
  public Node left;
  public Node right;
  private K key;
  private V value;
  public Node(K key, V value, Node left, Node right){
   this.key = key;
   this.value = value;
   this.left = left;
   this.right = right;
  }
  
  public K getKey(){
	  return key;
  }
  
  public V getValue (){
	  return value;
  }
 }
}