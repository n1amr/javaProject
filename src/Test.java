public class Test {
    public static void main(String[] args) {
	String src = "http://ghfcbs/d/dfgdf/12443/dfg/";
	System.out.println(src.replaceAll((".*/(\\d+)/.*"), "$1"));
    }
}
