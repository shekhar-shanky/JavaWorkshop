package day1.service;

import day1.dao.EmployeeDao;
import day1.model.Employee;

/**
 * Created by sshek8 on 8/9/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee getEmployee(String empID) {
        return employeeDao.get(empID);
    }
}
