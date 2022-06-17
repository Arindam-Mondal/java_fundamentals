package java17features.serializationdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class DeserializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("C:\\Users\\amond07\\Downloads\\Emp.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        //Java 17 Feature to create filter to deserialize filter
//        ObjectInputFilter filter1 =  ObjectInputFilter.Config.createFilter("java17features.serializationdemo.*");
        ObjectInputFilter filter2 =  ObjectInputFilter.allowFilter(c1->c1.equals(Employee.class), ObjectInputFilter.Status.REJECTED);
//        ObjectInputFilter finalFilter = ObjectInputFilter.merge(filter1,filter2);
        ois.setObjectInputFilter(filter2);

        Object obj = ois.readObject();
        Employee emp = (Employee) obj;

        System.out.println("Employee Id: " + emp.id);
        System.out.println("Employee Name: " + emp.name);
        System.out.println("Employee Salary: " + emp.salary);
        System.out.println("Employee SSN: " + emp.ssn);

    }
}
