// ShowInnerClass.java: Demonstrate using inner classes
public class ShowInnerClass {
    /** A method in the outer class */
    public void m() {
	new InnerClass();
    }

    // An inner class
    class InnerClass {
	/** A method in the inner class */
	public void mi() {
	    m();
	}
    }
}