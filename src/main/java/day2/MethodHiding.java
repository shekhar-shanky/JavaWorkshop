package day2;

/**
 * Created by sshek8 on 8/10/2016.
 */
public class MethodHiding extends Employee {

    public static void main(String[] args) {
        Employee e1 = new MethodHiding();
        int salary1 = Employee.calculateSalary();
        System.out.println(salary1);
        MethodHiding e2 = new MethodHiding();
        int salary2 = calculateSalary();
        System.out.println(salary2);
    }

    public static int calculateSalary() {
        return 11;
    }
}


class Employee {
    public static int calculateSalary() {
        return 10;
    }
}