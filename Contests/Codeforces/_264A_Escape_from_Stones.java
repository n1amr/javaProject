import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class _264A_Escape_from_Stones {
    public static void main(String[] args) throws Exception {
	String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
	int i = 0, j = s.length(), k = 0, Q[] = new int[j];
	while (i < j)
	    if ('l' != s.charAt(k++))
		Q[i++] = k;
	    else
		Q[--j] = k;
	PrintWriter o = new PrintWriter(System.out);
	for (int e : Q)
	    o.println(e);
	o.close();
    }
}