package day1;

import day1.dao.EmployeeDao;
import day1.model.Employee;
import day1.service.EmployeeServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created by sshek8 on 8/9/2016.
 */
public class EmployeeServiceImplTest {

    @Test
    public void testSaveEmployee() throws Exception {
        Employee employee = mock(Employee.class);//("001","Shashank","Shekhar");

        EmployeeDao mockEmployeeDao = mock(EmployeeDao.class);

        EmployeeServiceImpl test = new EmployeeServiceImpl(mockEmployeeDao);

        test.saveEmployee(employee);

        verify(mockEmployeeDao, times(1)).save(employee);
    }

    @Test
    public void testGetEmployee() throws Exception {
        Employee employee = new Employee("001", "Shashank", "Shekhar");

        EmployeeDao mockEmployeeDao = mock(EmployeeDao.class);
        when(mockEmployeeDao.get(employee.getEmpId())).thenReturn(employee);

        EmployeeServiceImpl test = new EmployeeServiceImpl(mockEmployeeDao);

        Employee result = test.getEmployee(employee.getEmpId());

        assertSame(employee, result);

    }
}