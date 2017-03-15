package day1.model;

import java.util.Objects;

/**
 * Created by sshek8 on 8/9/2016.
 */
public class Employee {

    private final String empId;
    private final String firstName;
    private final String lastName;

    public Employee(String empId, String firstName, String lastName) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;

        Employee that = (Employee) obj;

        return Objects.equals(this.empId, that.empId) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
