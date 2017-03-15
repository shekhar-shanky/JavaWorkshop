package day4.comparator;

import java.util.Objects;

/**
 * Created by sshek8 on 8/15/2016.
 */
public class Employee {

    private final String empId;
    private final String empName;
    private final String dept;
    private final Integer salary;

    public Employee(String empId, String empName, String dept, Integer salary) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDept() {
        return dept;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee that = (Employee) o;

        return Objects.equals(this.empId, that.empId) && Objects.equals(this.empName, that.empName) &&
                Objects.equals(this.dept, that.dept) && Objects.equals(this.salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, dept, salary);
    }
}
