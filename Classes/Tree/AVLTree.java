import java.util.Arrays;

public class AVLTree<E extends Comparable<E>> {
	public Node<E> root;
	public int size = 0;

	public static void main(String[] args) {
		Integer[] elements = (Integer[]) Arrays.asList(3, 5, 9, 1, 0, 2, 6, 10,
				7, 4, 8).toArray();
		AVLTree<Integer> bst = new AVLTree<>(elements);
		for (Integer r : elements) {
			Node<Integer> c = bst.get(r);
			System.out.println(c + "\tleft:" + c.left + "\t\tright:" + c.right);
		}
		bst.delete(9);
		bst.delete(1);
		bst.inorder();
	}

	public AVLTree() {
	}

	public AVLTree(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	public boolean search(E e) {
		return getFromParent(getParent(e), e) != null;
	}

	public Node<E> get(E e) {
		return getFromParent(getParent(e), e);
	}

	public Node<E> getFromParent(Node<E> parent, E e) {
		if (parent == null)
			return root;
		if (parent.left != null && parent.left.element.equals(e))
			return parent.left;
		else if (parent.right != null && parent.right.element.equals(e))
			return parent.right;
		return null;
	}

	public Node<E> getParent(E e) {
		Node<E> parent = null;
		Node<E> current = root;
		while (current != null)
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break;
		return parent;
	}

	public boolean add(E e) {
		if (root == null)
			root = create(e);
		else {
			Node<E> parent = getParent(e);

			if (search(e))
				return false;
			if (e.compareTo(parent.element) < 0)
				parent.left = create(e);
			else
				parent.right = create(e);
		}

		size++;
		balancePath(e);
		return true;
	}

	protected Node<E> create(E e) {
		return new Node<E>(e);
	}

	public void inorder() {
		inorder(root);
	}

	protected void inorder(Node<E> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	public void postorder() {
		postorder(root);
	}

	protected void postorder(Node<E> root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	public void preorder() {
		preorder(root);
	}

	protected void preorder(Node<E> root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static class Node<E extends Comparable<E>> {
		public E element;
		public Node<E> left;
		public Node<E> right;
		protected int height;

		public Node(E e) {
			element = e;
		}

		public String toString() {
			return element.toString();
		}

	}

	public java.util.ArrayList<Node<E>> path(E e) {
		java.util.ArrayList<Node<E>> list = new java.util.ArrayList<Node<E>>();
		Node<E> current = root;

		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0)
				current = current.left;
			else if (e.compareTo(current.element) > 0)
				current = current.right;
			else
				break;
		}

		return list;
	}

	public boolean delete(E e) {
		Node<E> parent = getParent(e);
		Node<E> current = getFromParent(parent, e);

		if (current == null)
			return false;

		if (current.left == null) {
			/*
			 * if (parent == null) root = current.right; else
			 */
			if (e.compareTo(parent.element) < 0)
				parent.left = current.right;
			else
				parent.right = current.right;
		} else {
			Node<E> parentOfRightMost = current;
			Node<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}

			current.element = rightMost.element;

			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		balancePath(e);
		return true;
	}

	private void updateHeight(Node<E> node) {
		if (node.left == null && node.right == null)
			node.height = 0;
		else if (node.left == null)
			node.height = 1 + (node.right).height;
		else if (node.right == null)
			node.height = 1 + (node.left).height;
		else
			node.height = 1 + Math.max((node.right).height, (node.left).height);
	}

	private int balanceFactor(Node<E> node) {
		if (node.right == null)
			return -node.height;
		else if (node.left == null)
			return +node.height;
		else
			return node.right.height - node.left.height;
	}

	private void balancePath(E e) {
		java.util.ArrayList<Node<E>> path = path(e);
		for (int i = path.size() - 1; i >= 0; i--) {
			Node<E> A = path.get(i);
			updateHeight(A);
			Node<E> parentOfA = A == root ? null : path.get(i - 1);

			switch (balanceFactor(A)) {
			case -2:
				if (balanceFactor(A.left) <= 0)
					balanceLL(A, parentOfA);
				else
					balanceLR(A, parentOfA);
				break;
			case +2:
				if (balanceFactor(A.right) >= 0)
					balanceRR(A, parentOfA);
				else
					balanceRL(A, parentOfA);
			}
		}
	}

	private void balanceLL(Node<E> A, Node<E> parentOfA) {
		Node<E> B = A.left;

		if (A == root)
			root = B;
		else if (parentOfA.left == A)
			parentOfA.left = B;
		else
			parentOfA.right = B;

		A.left = B.right;
		B.right = A;
		updateHeight(A);
		updateHeight(B);
	}

	private void balanceLR(Node<E> A, Node<E> parentOfA) {
		Node<E> B = A.left;
		Node<E> C = B.right;

		B.right = C.left;
		A.left = C;
		C.left = B;
		balanceLL(A, parentOfA);

		updateHeight(A);
		updateHeight(B);
		updateHeight(C);
	}

	private void balanceRR(Node<E> A, Node<E> parentOfA) {
		Node<E> B = A.right;

		if (A == root)
			root = B;
		else if (parentOfA.left == A)
			parentOfA.left = B;
		else
			parentOfA.right = B;

		A.right = B.left;
		B.left = A;
		updateHeight(A);
		updateHeight(B);
	}

	private void balanceRL(Node<E> A, Node<E> parentOfA) {
		Node<E> B = A.right;
		Node<E> C = B.left;

		B.left = C.right;
		A.right = C;
		C.right = B;
		balanceRR(A, parentOfA);

		updateHeight(A);
		updateHeight(B);
		updateHeight(C);
	}

	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}

	private class InorderIterator implements java.util.Iterator<E> {
		private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
		private int current = 0;

		public InorderIterator() {
			inorder();
		}

		private void inorder() {
			inorder(root);
		}

		private void inorder(Node<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override
		public boolean hasNext() {
			if (current < list.size())
				return true;
			return false;
		}

		@Override
		public E next() {
			return list.get(current++);
		}

		@Override
		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}
	}

	public void clear() {
		root = null;
		size = 0;
	}
}