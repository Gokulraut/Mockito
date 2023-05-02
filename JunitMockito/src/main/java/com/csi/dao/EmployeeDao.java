package com.csi.dao;


import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class EmployeeDao {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData (Employee employee){
 /*       AtomicLong idCounter =  new AtomicLong(100);
        long timestamp = System.currentTimeMillis();
        long nextLong = idCounter.incrementAndGet();
        String randomId = String.valueOf(timestamp)+String.valueOf(nextLong);

    //    int id = UUID.randomUUID().toString();
*/
      //  employee.setEmpId(Integer.parseInt(randomId));
        return employeeRepoImpl.save(employee);
    }

    public Optional<Employee>getDataById(int empId){
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee>getAllData(){
        return employeeRepoImpl.findAll();
    }
    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }
    public void deleteDataById(int empId){
        employeeRepoImpl.deleteById(empId);
    }

}
