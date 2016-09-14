public class BST<E extends Comparable<E>> {
  public Node<E> root;
  public int size = 0;

  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    bst.add(9);
    bst.add(8);
    bst.add(7);
    bst.add(5);
    bst.add(6);
    bst.add(4);
    bst.add(3);
    bst.add(2);
    bst.add(1);
    Node<Integer> parent = bst.getParent(5);
    System.out.println(parent.element);
    System.out.println(bst.getFromParent(parent, 5).element);
    bst.delete(5);
    bst.delete(9);
    bst.delete(1);
    bst.inorder();
  }

  public BST() {
  }

  public BST(E[] objects) {
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
    public E v;
    public Node<E> left;
    public Node<E> right;

    public Node(E e) {
      v = e;
    }

    public String toString() {
      return v.toString();
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
    return true;
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