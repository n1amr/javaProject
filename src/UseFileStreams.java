import java.io.*;
import java.util.*;

//Make Scanners and Writers "public static"

//public static Scanner in = new Scanner(new BufferedReader(
//	    new InputStreamReader(System.in)));
//public static PrintWriter out = new PrintWriter(new BufferedWriter(
//	    new OutputStreamWriter(System.out)));

public class UseFileStreams {
    public static void main(String[] args) throws Exception {
	_486A_Calculating_Function.in = new Scanner(new BufferedInputStream(
		new FileInputStream(new File("input.txt"))));
	_486A_Calculating_Function.out = new PrintWriter(
		new BufferedOutputStream(new FileOutputStream(new File(
			"output.txt"))));
	long start = System.currentTimeMillis();
	_486A_Calculating_Function.main(null);
	System.out.println("DONE!");
	System.out.printf("Time: %d ms, memory: %d KB",
		System.currentTimeMillis() - start, 0);
    }
}
