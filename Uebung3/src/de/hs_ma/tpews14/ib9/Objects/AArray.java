package de.hs_ma.tpews14.ib9.Objects;

import java.util.function.BiConsumer;

import de.hs_ma.tpews14.ib9.Interface.AssociativeArray;

public class AArray<K, V> implements AssociativeArray<K, V> {

	Node root;

	public AArray() {
		this.root = null;
	}

	public AArray(K k, V v) {
		root = new Node(k, v, null, null);

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root = null;
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
		return root.equals(null);
	}

	@Override
	public void put(K k, V v) {
		Node node =new Node(k, v, null, null);
		// Problem wegen k
		if (root == null) {
			root = new Node(k, v, null, null);
		} else {
			switch (node.getKey().compareTo(root.getKey())) {
			case 0:
				// nichts zu tun
				return;
			case -1:// Wir müssen nach links
				if (root.left == null) {
					this.setLeft(new AArray<K, V>());
				} else {
					this.getLeftTree().put(k, v);
				}
				break;
			case 1:// wir müssen nach rechts
				if (root.right == null) {
					this.setRight(new AArray<K, V>());
				} else {
					this.getRightTree().put(k, v);
				}
				break;
			default:
				// kommt nicht vor
			}

		}

	}

	@Override
	public void putAll(K[] k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(K k) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return count(root);
	}

	public int count(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + this.count(node.getLeft()) + this.count(node.getRight());
		}
	}

	@Override
	public void update(K k, V v) {

		if (get(v) == v) {
		} else {

		}
	}

	@Override
	public void forEach(BiConsumer<K, V> b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extractAll(K[] k) {
		// TODO Auto-generated method stub
		if (root == null) {

		} else {

		}
	}

	@Override
	public void map(BiConsumer<K, V> b) {
		// TODO Auto-generated method stub

	}

	public AArray<K, V> getLeftTree() {
		AArray<K, V> a = new AArray<K, V>();
		a.root = root.left;
		return a;
	}

	// linken Unterbaum setzen
	public void setLeft(AArray<K, V> a) {
		root.left = a.root;
	}

	public AArray<K, V> getRightTree() {
		AArray<K, V> a = new AArray<K, V>();
		a.root = root.right;
		return a;
	}

	public void setRight(AArray<K, V> a) {
		root.right = a.root;
	}

//	private int compareTo(int k, int s) {
//
//		if (k <= s) {
//			if (k < s) {
//				return -1;
//			} else {
//				return 0;
//			}
//		} else {
//			return 1;
//		}
//	}
//
//	private int compareTo(String k, String s) {
//		if (k.length() <= s.length()) {
//			if (k.length() < s.length()) {
//				return -1;
//			} else {
//				return 0;
//			}
//		} else {
//			return 1;
//		}
//	}

	@Override
	public void forEach(java.util.function.BiConsumer<K, V> b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void map(java.util.function.BiConsumer<K, V> b) {
		// TODO Auto-generated method stub

	}
	
	

	class Node {
		public Node left;
		public Node right;
		private K key;
		private V value;

		public Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public Node getRight() {
			return right;
		}

		public Node getLeft() {
			return left;
		}

		public int compareTo(K k) {
			if (k instanceof Number) {
				Integer tmp = (Integer) k;
				if (tmp.compareTo((Integer) k) <= 0) {
					if (tmp.compareTo((Integer) k) < 0) {
						return -1;
					} else {
						return 0;
					}
				} else {
					return 1;
				}
			} else {
				String tmp = (String) k;
				if (tmp.compareTo((String) k) <= 0) {
					if (tmp.compareTo((String) k) < 0) {
						return -1;
					} else {
						return 0;
					}
				} else {
					return 1;
				}
			}
		}
	}

}