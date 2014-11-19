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
		if (root == null) {
			return false;
		}
		if (v == root.getValue()) {
			return true;
		} else {
			if (getLeftTree() != null) {
				return getLeftTree().containsValue(v);
			} else {
				if (getRightTree() != null) {
					return getRightTree().containsValue(v);
				}
			}
			return false;
		}
	}

	@Override
	public boolean containsKey(K k) {
		if (root == null) {
			return false;
		}
		if (root.getKey() == k) {
			return true;
		} else {
			if (k.hashCode() < root.hash) {
				return getLeftTree().containsKey(k);
			} else {
				if (k.hashCode() > root.hash) {
					return getRightTree().containsKey(k);
				}
			}
			return false;
		}
	}

	//
	//
	// if (root == null) {
	// return false;
	// }
	// if (k == root.getKey()) {
	// return true;
	// } else {
	// if (getLeftTree() != null) {
	// return getLeftTree().containsKey(k);
	// } else {
	// if (getRightTree() != null) {
	// return getRightTree().containsKey(k);
	// }
	// }
	// return false;
	// }

	@Override
	public V get(K k) {
		if (containsKey(k)) {
			if (root.key == k) {
				return root.getValue();
			} else {
				if (getLeftTree() != null) {
					return getLeftTree().get(k);
				} else {
					if (getRightTree() != null) {
						return getRightTree().get(k);
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root.equals(null);
	}

	@Override
	public void put(K k, V v) {
		Node node = new Node(k, v, null, null);
		// Problem wegen k
		if (root == null) {
			root = node;
		} else {
			switch (node.compareTo(root)) {
			case 0:
				// nichts zu tun
				return;
			case -1:// Wir müssen nach links
				if (root.left == null) {
					root.left = node;
				} else {
					this.getLeftTree().put(k, v);
				}
				break;
			case 1:// wir müssen nach rechts
				if (root.right == null) {
					root.right = node;
				} else {
					this.getRightTree().put(k, v);
				}
				break;
			default:

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

	public void print() {
		ausgabe(root, 0);
	}

	public void ausgabe(Node n, int level) {
		if (n != null) {
			System.out.println("level: " + level + ", " + n.key + ", "
			        + n.value + ", Hashcode: " + n.hash);
			this.ausgabe(n.left, level + 1);
			this.ausgabe(n.right, level + 1);
		}
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
		if (containsKey(k)) {
			if (root.key == k) {
				root.setValue(v);
			} else {
				if (getLeftTree() != null) {
					getLeftTree().update(k, v);
				} else {
					if (getRightTree() != null) {
						getRightTree().update(k, v);
					}
				}
			}
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

	public class Node {
		public Node left;
		public Node right;
		private K key;
		private V value;
		private int hash;

		public Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.hash = hashCode();
		}

		public void setValue(V v) {
			value = v;
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

		public int compareTo(Node k) {
			if (hash <= k.hashCode()) {
				if (hash < k.hashCode()) {
					return -1;
				} else {
					return 0;
				}
			} else {
				return 1;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
			        + ((getKey() == null) ? 0 : getKey().hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AArray other = (AArray) obj;
			if (root == null) {
				if (other.root != null)
					return false;
			} else if (!root.equals(other.root))
				return false;
			return true;
		}
	}

}