import java.io.*;

public class generateInput {

    // out.print("Hello World");
    private static void write() {
	out.println("1");
	for (int i = 0; i < 1; i++) {
	    out.println("9999 1000000000000");
	    for (int j = 0; j < 3333; j++) {
		out.print("ijk");
	    }
	    out.println();
	}
    }

    public static PrintWriter out;

    public static void main(String[] args) throws Exception {
	File mFile = new File("input.txt");
	mFile.createNewFile();
	out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
		mFile)));

	long start = System.currentTimeMillis();
	write();
	out.close();
	System.out.println("DONE!");
	System.out.printf("Time: %d ms, memory: %d KB",
		System.currentTimeMillis() - start, mFile.length() * 16 / 1024);

    }

}
