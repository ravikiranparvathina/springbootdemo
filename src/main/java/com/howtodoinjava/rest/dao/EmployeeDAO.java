package com.howtodoinjava.rest.dao;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static final Employees list = new Employees();
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    
    static 
    {
        list.getEmployeeList().add(new Employee(idCounter.incrementAndGet(), "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(idCounter.incrementAndGet(), "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(idCounter.incrementAndGet(), "David", "Kameron", "titanic@gmail.com"));
    }
    
    public synchronized Employees getAllEmployees() 
    {
        return list;
    }
    
    public synchronized void addEmployee(Employee employee) {
        employee.setId(idCounter.incrementAndGet());
        list.getEmployeeList().add(employee);
    }
}
