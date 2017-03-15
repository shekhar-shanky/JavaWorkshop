package day4.comparator;

import java.util.Comparator;

/**
 * Created by sshek8 on 8/15/2016.
 */
public class EmployeeNameComparator implements Comparator<Employee> {

    public int compare(Employee o1, Employee o2) {
        return o1.getEmpId().compareTo(o2.getEmpId());
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }
}
