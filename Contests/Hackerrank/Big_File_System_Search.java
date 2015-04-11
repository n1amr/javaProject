import java.util.*;

public class Big_File_System_Search {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	ArrayList<HashMap<Integer, Integer>> d = new ArrayList<HashMap<Integer, Integer>>();
	for (int i = 0; i < N; i++) {
	    int M = in.nextInt();
	    HashMap<Integer, Integer> file = new HashMap<Integer, Integer>();
	    d.add(file);
	    for (int j = 0; j < M; j++) {
		int x = in.nextInt();
		if (!file.containsKey(x))
		    file.put(x, 0);
		file.put(x, file.get(x) + 1);
	    }
	}

	int Q = in.nextInt();
	for (int i = 0; i < Q; i++) {
	    int T = in.nextInt();
	    int K = in.nextInt();
	    HashMap<Integer, Integer> q = new HashMap<Integer, Integer>();
	    for (int j = 0; j < K; j++) {
		int x = in.nextInt();
		if (!q.containsKey(x))
		    q.put(x, 0);
		q.put(x, q.get(x) + 1);
	    }

	    int c = 0;
	    switch (T) {
		case 1:
		    for (int j = 0; j < N; j++)
			if (haveAll(d.get(j), q))
			    c++;
		    break;
		case 2:
		    for (int j = 0; j < N; j++)
			if (haveSome(d.get(j), q))
			    c++;
		    break;
		case 3:
		    for (int j = 0; j < N; j++)
			if (!haveAll(d.get(j), q) && haveSome(d.get(j), q))
			    c++;
		    break;
	    }
	    System.out.println(c);
	}
    }

    private static boolean haveAll(HashMap<Integer, Integer> file,
	    HashMap<Integer, Integer> q) {
	boolean found = true;
	for (Integer z : q.keySet())
	    if (!file.containsKey(z) || q.get(z) > file.get(z))
		found = false;
	return found;
    }

    private static boolean haveSome(HashMap<Integer, Integer> file,
	    HashMap<Integer, Integer> q) {
	boolean found = false;
	for (Integer z : q.keySet())
	    if (file.containsKey(z))
		found = true;
	return found;
    }
}