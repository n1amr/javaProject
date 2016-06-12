import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class generateInput {

	// out.print("Hello World");
	private static void write() {
		out.println("1500 1500");
		for (int i = 0; i < 3000; i++) {
			char[] x = new char[20];
			int rndd = 5;
			for (int j = 0; j < rndd; j++)
				x[j] = (char) (Math.random() * 26 + 0x61);
			for (int j = rndd; j < x.length; j++)
				x[j] = 'a';
			out.println(x);
		}
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
