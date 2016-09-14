import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegisterStudent3TierServer {
  public static void main(String[] args) {
    try {
      StudentServerInterface obj = new Student3TierImpl();
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind("StudentServerInterfaceImpl", obj);
      System.out.println("Student server " + obj + " registered");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}