import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _Extraterrestrial_Rotations {
    static Scanner in;
    static PrintWriter out;

    public static void main(String[] args) throws FileNotFoundException {
	in = new Scanner(new BufferedInputStream(new FileInputStream(new File("input.txt"))));
	out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))));
	int nCases = in.nextInt();
	in.nextLine();
	for (int CASE = 1; CASE <= nCases; CASE++)
	    solve();
	out.close();
	System.out.println("Done");
    }

    static String Front, Up, Down, Left, Right, Back;

    static void solve() {
	Front = in.next();
	Up = in.next();
	Down = in.next();
	Left = in.next();
	Right = in.next();
	Back = in.nextLine().trim();
	int n = in.nextInt();
	for (int i = 0; i < n; i++) {
	    char axis = in.next().charAt(0);
	    int m = in.nextInt() % 4;
	    switch (axis) {
		case 'X':
		    rotateX(m);
		    break;
		case 'Y':
		    rotateY(m);
		    break;
		case 'Z':
		    rotateZ(m);
		    break;
	    }
	}
	out.println(Front + " " + Up + " " + Down + " " + Left + " " + Right + " " + Back);
    }

    private static void rotateZ(int m) {
	for (int i = 0; i < m; i++) {
	    String temp = Front;
	    Front = Left;
	    Left = Back;
	    Back = Right;
	    Right = temp;
	}
    }

    private static void rotateY(int m) {
	for (int i = 0; i < m; i++) {
	    String temp = Left;
	    Left = Down;
	    Down = Right;
	    Right = Up;
	    Up = temp;
	}
    }

    private static void rotateX(int m) {
	for (int i = 0; i < m; i++) {
	    String temp = Down;
	    Down = Back;
	    Back = Up;
	    Up = Front;
	    Front = temp;
	}
    }
}
