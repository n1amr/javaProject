import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class _388A_Fox_and_Box_Accumulation {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	Integer[] boxes = new Integer[n];
	for (int i = 0; i < n; i++)
	    boxes[i] = in.nextInt();
	Arrays.sort(boxes);
	Vector<Vector<Integer>> v = new Vector<>();
	v.add(new Vector<Integer>());
	int pile = 0;
	int leftBoxes = n;
	while (leftBoxes > 0) {
	    for (int i = 0; i < boxes.length; i++)
		if (boxes[i] >= v.get(pile).size()) {
		    v.get(pile).add(boxes[i]);
		    boxes[i] = -1;
		    leftBoxes--;
		}

	    if (leftBoxes != 0) {
		v.add(new Vector<Integer>());
		pile++;
	    }
	}
	System.out.println(pile + 1);
    }
}