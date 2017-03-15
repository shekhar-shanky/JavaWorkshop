package day2;

/**
 * Created by sshek8 on 8/10/2016.
 */
public class StaticInitBlockConstDemo {

    public static void main(String[] args) {
//        System.out.println("-------------------------------------");
//        Employee1 e1 = new Employee1();
//        e1.doStuff();
//
//        System.out.println("-------------------------------------");
//        Employee1 e2 = new Manager1();
//        e2.doStuff();
//
//        System.out.println("-------------------------------------");
//        Manager1 e3 = new Manager1();
//        e3.doStuff();

        System.out.println("-------------------------------------");
        Employee1 e4 = new SeniorManager();
        e4.doStuff();

        System.out.println("-------------------------------------");

    }


}

class Employee1 {
    private static String str1 = "Class Variable";

    static {
        System.out.println("Employee1.static initializer");
    }

    private String str2 = "Class Variable";

    {
        System.out.println("Employee1.instance initializer");
    }

    public Employee1() {
//        super();
        System.out.println("Employee1.Employee1");
    }

    public void doStuff() {
        System.out.println("Employee1.doStuff");
    }
}

class Manager1 extends Employee1 {

    static {
        System.out.println("Manager1.static initializer");
    }

    {
        System.out.println("Manager1.instance initializer");
    }

    public Manager1() {
        System.out.println("Manager1.Manager1");
    }

    public void doStuff() {
        System.out.println("Manager1.doStuff");
    }


}

class SeniorManager extends Manager1 {
    static {
        System.out.println("SeniorManager.static initializer");
    }

    {
        System.out.println("SeniorManager.instance initializer");
    }

    public SeniorManager() {
        System.out.println("SeniorManager.SeniorManager");
    }

    public void doStuff() {
        System.out.println("SeniorManager.doStuff");
    }
}

