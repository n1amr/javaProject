import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws Exception {
	Scanner in = new Scanner(System.in);

	System.out.print("Enter file path: ");
	String fname = in.nextLine();

	System.out.print("Enter shift ammount: ");
	int shift = in.nextInt();

	Scanner fin = new Scanner(new FileInputStream(new File(fname)));
	fname = fname.substring(0, fname.length() - 4) + " SHIFTED.srt";
	PrintWriter fout = new PrintWriter(
		new FileOutputStream(new File(fname)));

	String s;
	while (fin.hasNextLine()) {
	    s = fin.nextLine();
	    if (s.equals("")) {
		fout.println(s);
		fout.println(fin.nextLine());
		s = fin.nextLine();

		String regex = "(\\d\\d):(\\d\\d):(\\d\\d)(.+)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		m.matches();
		GregorianCalendar date = new GregorianCalendar(0, 0, 0,
			Integer.valueOf(m.group(1)),
			Integer.valueOf(m.group(2)),
			Integer.valueOf(m.group(3)));
		date.add(GregorianCalendar.SECOND, shift);
		s = date.getTime().toString().substring(11, 19);
		fout.println(s + m.group(4));
	    } else
		fout.println(s);
	}
	fout.close();
    }
}