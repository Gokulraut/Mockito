package com.csi.dao.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;


    @MockBean
    EmployeeRepo employeeRepo;

    @Test
    public void saveDataTest(){

        Employee employee=new Employee(1,"Gokul","pune","1122334455","gokul@gmail.com",new Date());

        employeeDao.saveData(employee);
        verify(employeeRepo,times(1)).save(employee);
    }

    @Test
    public void getAllData(){

        when(employeeRepo.findAll()).thenReturn(Stream.of(new Employee(1,"Gokul","pune","1122334455","gokul@gmail.com",new Date()),new Employee(3,"Gokul","pune","1122334455","gokul@gmail.com",new Date()),
                new Employee(2,"Gokul","pune","1122334455","gokul@gmail.com",new Date()),new Employee(4,"Gokul","pune","1122334455","gokul@gmail.com",new Date())).collect(Collectors.toList()));
assertEquals(4,employeeDao.getAllData().size());


    }
    @Test
    public void updateData() {

        Employee employee=new Employee(1,"Gl","pune","55","gokul@gmail.com",new Date());

        employeeDao.updateData(employee);

        verify(employeeRepo,times(1)).save(employee);

    }

    @Test

            public void delete() {
        Employee employee = new Employee(3, "Gl", "pune", "55", "gokul@gmail.com", new Date());

        employeeDao.deleteDataById(3);
        verify(employeeRepo,times(1)).deleteById(employee.getEmpId()); 


    }

}
