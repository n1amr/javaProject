import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class _518C_Anya_and_Smartphone {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	int n = in.nextInt();
	int m = in.nextInt();
	int k = in.nextInt();
	int[] menu = new int[n];
	int[] placeOf = new int[n];
	for (int i = 0; i < n; i++) {
	    menu[i] = in.nextInt() - 1;
	    placeOf[menu[i]] = i;
	}
	long gestures = 0;
	for (int i = 0; i < m; i++) {
	    int newApp = in.nextInt() - 1;
	    gestures += placeOf[newApp] / k + 1;
	    if (placeOf[newApp] != 0) {
		int oldApp = menu[placeOf[newApp] - 1];

		int newAppIndex = placeOf[newApp];
		int oldAppIndex = placeOf[newApp] - 1;

		// Replace in Menu
		menu[oldAppIndex] = newApp;
		menu[newAppIndex] = oldApp;

		placeOf[newApp]--; // Move Up
		placeOf[oldApp]++; // Move Down
	    }
	}
	out.println(gestures);
	out.close();
    }
}
