import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class StudentServerInterfaceImpl extends UnicastRemoteObject implements StudentServerInterface {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// Stores scores in a map indexed by name
	private HashMap<String, Double> scores = new HashMap<String, Double>();

	public StudentServerInterfaceImpl() throws RemoteException {
		initializeStudent();
	}

	/**
	 * Initialize student information
	 */
	protected void initializeStudent() {
		scores.put("John", new Double(90.5));
		scores.put("Michael", new Double(100));
		scores.put("Michelle", new Double(98.5));
	}

	/**
	 * Implement the findScore method from the Student interface
	 */
	public double findScore(String name) throws RemoteException {
		Double d = scores.get(name);

		if (d == null) {
			System.out.println("Student " + name + " is not found ");
			return -1;
		} else {
			System.out.println("Student " + name + "\'s score is " + d.doubleValue());
			return d.doubleValue();
		}
	}
}
