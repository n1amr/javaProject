import java.io.*;

public class generateInput {

    // out.print("Hello World");
    private static void write() {
	out.println("100");
	for (int i = 1; i <= 100; i++)
	    out.println(i);
    }

    public static PrintWriter out;

    public static void main(String[] args) throws Exception {
	File mFile = new File("input.txt");
	mFile.createNewFile();
	out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(mFile)));

	long start = System.currentTimeMillis();
	write();
	out.close();
	System.out.println("DONE!");
	System.out.printf("Time: %d ms, memory: %d KB", System.currentTimeMillis() - start, mFile.length() * 16 / 1024);

    }

}
