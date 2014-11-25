package de.hs_ma.tpews14.ib9.Objects;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
		root = null;
	}

	@Override
	public boolean containsValue(V v) {
		boolean found = false;
		if (root == null) {
			return false;
		}
		if (root.getValue() == v) {
			return true;
		} else {
			if (getLeftTree() != null) {
				found = getLeftTree().containsValue(v);
			}
			if (getRightTree() != null) {
				found = (found || getRightTree().containsValue(v));
			}
		}
		return found;
	}

	@Override
	public boolean containsKey(K k) {
		boolean found = false;
		if (root == null) {
			return false;
		}
		if (root.getKey() == k) {
			return true;
		} else {
			if (getLeftTree() != null) {
				found = getLeftTree().containsKey(k);
			}
			if (getRightTree() != null) {
				found = (found || getRightTree().containsKey(k));
			}
		}
		return found;
	}

	@Override
	public V get(K k) {
		if (containsKey(k)) {
			if (root.key == k) {
				return root.getValue();
			} else {
				if (k.hashCode() < root.hash) {
					return getLeftTree().get(k);
				} else {
					if (k.hashCode() > root.hash) {
						return getRightTree().get(k);
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
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
					node.setParent(root);
					root.left = node;
				} else {
					this.getLeftTree().put(k, v);
				}
				break;
			case 1:// wir müssen nach rechts
				if (root.right == null) {
					node.setParent(root);
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
	public void putAll(AArray<K, V> b) {
		b.forEach((key, value) -> this.put(key, value));
	}

	@Override
	public V remove(K k) {
		final V v = get(k);

		if (root == null) {
			return null;
		}
		AArray<K, V> leftSubTree = this.getLeftTree();
		AArray<K, V> rightSubTree = this.getRightTree();

		Node node = new Node(k, null, null, null);
		switch (node.compareTo(root)) {
		case 0:
			if (root.left == null) {
				root = root.right;

			} else {
				if (root.right == null) {
					root = root.left;

				} else {
					Node n = leftSubTree.root;
					while (n.right != null) {
						n = n.right;
					}
					K key = n.getKey();
					leftSubTree.remove(key);
					root = n;
					n.left = leftSubTree.root;
					n.right = rightSubTree.root;

				}
			}
			break;
		case 1:

			rightSubTree.remove(k);
			root.right = rightSubTree.root;

			break;
		case -1:

			leftSubTree.remove(k);
			root.left = leftSubTree.root;

			break;
		default:
		}
		return v;
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
				if (k.hashCode() < root.hash) {
					getLeftTree().update(k, v);
				} else {
					if (k.hashCode() > root.hash) {
						getRightTree().update(k, v);
					}
				}
			}
		}
	}

	@Override
	public void forEach(BiConsumer<K, V> b) {
		if (root == null) {
			return;
		} else {
			b.accept(root.key, root.value);
		}
		if (root.left != null) {
			getLeftTree().forEach(b);
		}
		if (root.right != null) {
			getRightTree().forEach(b);
		}
	}

	@Override
	public void extractAll(AArray<K, V> b) {
		b.putAll(this);
	}

	@Override
	public AArray<K, V> map(BiFunction<K, V, V> bi) {
		AArray<K, V> tree = new AArray<K, V>();
		return this.map(this.root, bi, tree);
	}

	public AArray<K, V> map(Node n, BiFunction<K, V, V> bi, AArray<K, V> tree) {
		if (n != null) {
			tree.put(n.getKey(), bi.apply(n.getKey(), n.getValue()));

			this.map(n.left, bi, tree);
			this.map(n.right, bi, tree);
		}
		return tree;
	}

	@Override
	public String toString() {
		return "{" + ausgabe(root) + "}";
	}

	public String ausgabe(Node n) {
		String str = "";

		if (n == null) {
			return str;
		}
		str += n;
		str += ausgabe(n.left) + ausgabe(n.right);
		return str;

	}

	public AArray<K, V> getLeftTree() {
		AArray<K, V> a = new AArray<K, V>();
		a.root = root.left;

		return a;
	}

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

	private class Node {
		public Node left;
		public Node right;
		private K key;
		private V value;
		private int hash;
		private Node parent;

		public Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.hash = hashCode();
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getParent() {
			return parent;
		}

		private void setValue(V v) {
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

		@Override
		public String toString() {
			return key + "=" + value + hash + ", ";
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
			AArray<K, V> other = (AArray<K, V>) obj;
			if (root == null) {
				if (other.root != null)
					return false;
			} else if (!root.equals(other.root))
				return false;
			return true;
		}

	}

}