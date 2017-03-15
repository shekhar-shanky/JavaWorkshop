package day1.dao;

import day1.model.Employee;

/**
 * Created by sshek8 on 8/9/2016.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee get(String empId);
}
