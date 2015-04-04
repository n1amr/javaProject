import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtitlesShift {
    public static void main(String[] args) throws Exception {

	if (args.length == 0) {
	    args = new String[2];

	    Scanner in = new Scanner(System.in);

	    System.out.print("Enter file path: ");
	    args[0] = in.nextLine();

	    System.out.print("Enter shift ammount in milliseconds: ");
	    args[1] = in.nextLine();
	}

	String fname = args[0];
	int shift = new Integer(args[1]);

	Scanner fin = new Scanner(new FileInputStream(new File(fname)));
	fname = fname.substring(0, fname.length() - 4) + " SHIFTED.srt";
	PrintWriter fout = new PrintWriter(
		new FileOutputStream(new File(fname)));

	String line;
	while (fin.hasNextLine()) {
	    line = fin.nextLine();
	    if (line.matches(TIME_REGEX + " --> " + TIME_REGEX))
		line = increment(line, shift);
	    fout.println(line);
	}
	fout.close();
    }

    static final String TIME_REGEX = "(\\d\\d+):(\\d\\d):(\\d\\d),(\\d\\d\\d)";

    static String increment(String line, int shift) {
	String[] words = line.split(" ");
	words[0] = millisToString(stringToMillis(words[0]) + shift);
	words[2] = millisToString(stringToMillis(words[2]) + shift);
	line = words[0] + " " + words[1] + " " + words[2];
	return line;
    }

    private static String millisToString(long millis) {
	int d0 = (int) (millis % 1000);
	millis /= 1000;

	int d1 = (int) (millis % 60);
	millis /= 60;

	int d2 = (int) (millis % 60);
	millis /= 60;

	int d3 = (int) millis;

	String line = toStringWithLength(d3, 2) + ":"
		+ toStringWithLength(d2, 2) + ":" + toStringWithLength(d1, 2)
		+ "," + toStringWithLength(d0, 3);
	return line;
    }

    private static long stringToMillis(String line) {
	Pattern p = Pattern.compile(TIME_REGEX);
	Matcher m = p.matcher(line);
	m.matches();

	int d3 = new Integer(m.group(1));
	int d2 = new Integer(m.group(2));
	int d1 = new Integer(m.group(3));
	int d0 = new Integer(m.group(4));

	long millis = d0 + 1000 * (d1 + 60 * (d2 + 60 * d3));
	return millis;
    }

    private static String toStringWithLength(int n, int i) {
	char[] r = new char[i];
	Arrays.fill(r, '0');

	char[] s = Integer.toString(n).toCharArray();
	int z = r.length - s.length;
	System.arraycopy(s, 0, r, z, s.length);
	return new String(r);
    }
}