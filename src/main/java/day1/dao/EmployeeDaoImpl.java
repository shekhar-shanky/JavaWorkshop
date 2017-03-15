package day1.dao;

import day1.model.Employee;

/**
 * Created by sshek8 on 8/9/2016.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    public void save(Employee employee) {
        System.out.println("To be saved!! " + employee.toString());
    }

    public Employee get(String empId) {
        Employee employee = new Employee(empId, "Shashank", "Shekhar");
        return employee;
    }
}
