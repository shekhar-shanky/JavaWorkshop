package day1.service;

import day1.model.Employee;

/**
 * Created by sshek8 on 8/9/2016.
 */
public interface EmployeeService {

    void saveEmployee(Employee employee);

    Employee getEmployee(String empID);

}
