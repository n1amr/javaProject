import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Problem_AM {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

  }

  public void bfs() {
    //BFS uses Queue data structure
    Queue q = new LinkedList();
    q.add(this.rootNode);
    printNode(this.rootNode);
    rootNode.visited = true;
    while (!q.isEmpty()) {
      Node n = (Node) q.remove();
      Node child = null;
      while ((child = getUnvisitedChildNode(n)) != null) {
        child.visited = true;
        printNode(child);
        q.add(child);
      }
    }
    //Clear visited property of nodes
    clearNodes();
  }

  public class Node {
    Char data;

    Public Node(char c) {
      this.data = c;
    }
  }
}

