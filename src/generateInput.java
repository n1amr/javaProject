import java.io.*;

public class generateInput {
    public static void main(String[] args) throws FileNotFoundException {
	PrintWriter out = new PrintWriter(new BufferedOutputStream(
		new FileOutputStream(new File("input.txt"))));
	out.println("15000 15000");
	for (int i = 0; i < 30000; i++) {
	    char[] x = new char[20];
	    int rndd = 5;
	    for (int j = 0; j < rndd; j++) {
		x[j] = (char) (Math.random() * 26 + 0x61);
	    }
	    for (int j = rndd; j < x.length; j++) {
		x[j] = 'a';
	    }
	    out.println(x);
	}
	out.close();
    }
}
