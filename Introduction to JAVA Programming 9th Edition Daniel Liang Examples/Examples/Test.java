import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<String>();

	list.add("Beijing");

	list.add(2, "A");

	System.out.println(list);
    }
}