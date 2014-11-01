import java.io.FileNotFoundException;
import java.util.*;

public class _4B_Before_an_Exam {
    public static void main(String[] args) throws FileNotFoundException {
	Scanner in = new Scanner(System.in);
	int d = in.nextInt();
	int sumTime = in.nextInt();
	int[] minTimes = new int[d];
	int[] maxTimes = new int[d];
	int minTime = 0;
	int maxTime = 0;
	for (int i = 0; i < d; i++) {
	    minTime += minTimes[i] = in.nextInt();
	    maxTime += maxTimes[i] = in.nextInt();
	}
	if (!(sumTime >= minTime && sumTime <= maxTime))
	    System.out.println("NO");
	else {
	    System.out.println("YES");
	    int i = 0;
	    for (; i < maxTimes.length
		    && minTime + maxTimes[i] - minTimes[i] <= sumTime; i++) {
		minTime += maxTimes[i] - minTimes[i];
		minTimes[i] = maxTimes[i];
	    }
	    if (minTime < sumTime)
		minTimes[i] += sumTime - minTime;
	    for (int x : minTimes)
		System.out.print(x + " ");
	}
    }
}
