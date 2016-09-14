package com.n1amr;

class Employee implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  String address;
  transient int SSN;
  int number;

  public void mailCheck() {
    System.out.println("Deserialized Employee...");
    System.out.println("Name: " + name);
    System.out.println("Address: " + address);
    System.out.println("SSN: " + SSN);
    System.out.println("Number: " + number);
  }
}

public class Serialization {

  public static void main(String args[]) {
    Employee e = new Employee();
    e.name = "Reyan Ali";
    e.address = "Phokka Kuan, Ambehta Peer";
    e.SSN = 11122333;
    e.number = 101;
    File mFile = new File("serialized_obj.ser");
    try {
      mFile.createNewFile();
      FileOutputStream fileOut = new FileOutputStream(mFile);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(e);
      out.close();
      fileOut.close();
      System.out.printf("Serialized data is saved in /tmp/employee.ser\n");
    } catch (IOException i) {
    }
    e = null;
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(mFile));
      e = (Employee) in.readObject();
      in.close();
    } catch (IOException i) {
    } catch (ClassNotFoundException c) {
    }
    e.mailCheck();
  }
}