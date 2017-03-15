package day7.clone.Type1;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee("001", "SHASHANK", "DELIVERY");
        Employee clonedEmployee = (Employee) employee.clone();

        System.out.println(employee.hashCode());
        System.out.println(System.identityHashCode(employee));
        System.out.println(clonedEmployee.hashCode());
        System.out.println(System.identityHashCode(clonedEmployee));
    }

}

class Employee implements Cloneable {
    private final String empId;
    private final String empName;
    private final String dept;

    public Employee(String empId, String empName, String dept) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}