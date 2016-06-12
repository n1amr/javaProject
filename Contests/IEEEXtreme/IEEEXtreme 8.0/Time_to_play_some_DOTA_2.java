import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Time_to_play_some_DOTA_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
						System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		Hero[] a = new Hero[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder(in.nextLine());
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) == ' ')
					sb.setCharAt(j, (char) 0);
				else if (sb.charAt(j) == ',')
					sb.setCharAt(j, ' ');
				else if (sb.charAt(j) == ':')
					sb.setCharAt(j, ' ');
			}
			String line = sb.toString();
			Scanner h = new Scanner(line);
			String name = h.next();
			char type = h.next().charAt(0);
			int win = h.nextInt();
			int lose = h.nextInt();
			a[i] = new Hero(name, win, lose, i + 1, type);
		}
		Arrays.sort(a);
		int[] types = new int[3];
		for (int i = 0; i < m; i++) {
			StringBuilder sb = new StringBuilder(a[i].Name);
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) == (char) 0)
					sb.setCharAt(j, ' ');
			}
			out.println(sb.toString());
			char type = a[i].type;
			switch (type) {
				case 'I':
					types[0]++;
					break;
				case 'S':
					types[1]++;
					break;
				case 'A':
					types[2]++;
					break;
			}
		}
		out.println("\nThis set of heroes: ");
		out.printf("Contains %.2f percentage of Intelligence\n", types[0]
						* 100.0 / m);
		out.printf("Contains %.2f percentage of Strength\n", types[1] * 100.0
						/ m);
		out.printf("Contains %.2f percentage of Agility\n", types[2] * 100.0
						/ m);
		out.close();
	}
}

class Hero implements Comparable<Hero> {
	char type;
	String Name;
	int quality;

	public Hero(String name, int win, int lose, int rank, char type) {
		Name = name;
		quality = (100 * win / (win + lose)) * rank;
		this.type = type;
	}

	public int compareTo(Hero o) {
		return o.quality - quality;
	}

	@Override
	public String toString() {
		return Name + " " + quality;
	}
}
