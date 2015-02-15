import java.io.*;
import java.util.*;

//Make Scanners and Writers "public static"
public class UseFileStreams {
    public static void main(String[] args) throws FileNotFoundException {
	_514C_Watto_and_Mechanism.in = new Scanner(new BufferedInputStream(
		new FileInputStream(new File("input.txt"))));
	_514C_Watto_and_Mechanism.out = new PrintWriter(
		new BufferedOutputStream(new FileOutputStream(new File(
			"output.txt"))));
	_514C_Watto_and_Mechanism.main(null);
    }
}
