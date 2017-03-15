package day7.clone.deep;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class DeepCopyDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address add = new Address("BLR", "INDIA");
        Employee emp = new Employee("001", "SHASHANK", "DELIVERY", add);

        Employee clone = (Employee) emp.clone();

        System.out.println("Original Employee: " + emp.hashCode());
        System.out.println("Cloned Employee: " + clone.hashCode());
        System.out.println("Original Address : " + emp.getAddress().hashCode());
        System.out.println("Cloned Address : " + clone.getAddress().hashCode());
        System.out.println(emp.toString());
        System.out.println(clone.toString());
        clone.getAddress().setState("USA");
        System.out.println(clone.toString());
        System.out.println(emp.toString());

    }

}

class Employee implements Cloneable {
    private String empId;
    private String empName;
    private String dept;
    private Address address;

    public Employee(String empId, String empName, String dept, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", dept='" + dept + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee e = (Employee) super.clone();
        e.address = (Address) e.address.clone();
        return e;
    }
}

class Address implements Cloneable {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}