package day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by sshek8 on 8/11/2016.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Emp e1 = new Emp("Abc", "1");
        Emp e2 = new Emp("Abc", "2");
        Emp e3 = new Emp("Abc", "3");
        Emp e4 = new Emp("Abc", "1");

        Map<Emp, Integer> map = new HashMap<Emp, Integer>();

        map.put(e1, new Integer(11));
        map.put(e2, new Integer(11));
        map.put(e3, new Integer(11));
        map.put(e4, new Integer(15));

        System.out.println("------------------------------------");
        System.out.println(map.size());
        System.out.println(map.get(new Emp("Abc", "1")));
        System.out.println(map.get(e1));
        System.out.println(map.get(e4));
        System.out.println("------------------------------------");
    }

}

class Emp {

    private String empName;
    private String empId;

    public Emp(String empName, String empId) {
        this.empName = empName;
        this.empId = empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emp)) return false;

        Emp emp = (Emp) o;

        return Objects.equals(this.empName, emp.empName) && Objects.equals(this.empId, emp.empId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(empName, empId);
    }
}
