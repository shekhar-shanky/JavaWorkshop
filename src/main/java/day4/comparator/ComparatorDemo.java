package day4.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sshek8 on 8/15/2016.
 */
public class ComparatorDemo {

    public static void main(String[] args) throws InterruptedException {
        Employee emp1 = new Employee("001", "SS", "Dept1", new Integer(1));
        Employee emp2 = new Employee("002", "ABC", "dept2", new Integer(2));
        Employee emp3 = new Employee("002", "dsfdsfr", "dept3", new Integer(4));
        Employee emp4 = new Employee("003", "erewr", "Dept4", new Integer(5));
        Employee emp5 = new Employee("004", "sads", "dept3", new Integer(7));
        Employee emp6 = new Employee("0004", "ZZZ", "dept3", new Integer(8));

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);

//        System.out.println(employees);

        for (int i = 0; i < 20; i++) {
            long startTime1 = System.nanoTime();
            Collections.sort(new ArrayList(employees), new EmployeeNameComparator());
            long endTime1 = System.nanoTime();
            System.out.println("Time Elapsed " + (i + 1) + " : " + (endTime1 - startTime1));
            Thread.sleep(1000);
        }
//
//        long startTime1 = System.nanoTime();
//        Collections.sort(new ArrayList(employees), new EmployeeNameComparator());
//        long endTime1 = System.nanoTime();
//        System.out.println("Time Elpased 1 : " + (endTime1 - startTime1));
//        System.out.println(employees);
//
//        long startTime2 = System.nanoTime();
//        Collections.sort(new ArrayList(employees), new EmployeeNameComparator());
//        long endTime2 = System.nanoTime();
//        System.out.println("Time Elpased 2 : " + (endTime2 - startTime2));
//        System.out.println(employees);
//
//        long startTime3 = System.nanoTime();
//        Collections.sort(new ArrayList(employees), new EmployeeNameComparator());
//        long endTime3 = System.nanoTime();
//        System.out.println("Time Elpased 3 : " + (endTime3 - startTime3));
//        System.out.println(employees);

    }
}
