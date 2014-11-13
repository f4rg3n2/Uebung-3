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
  if(root.equals(null)){
   root = new Node(k, v);
  }else{
   root.right = new Node(k, v);
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
  
 }
}