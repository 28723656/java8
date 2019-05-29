package com.java.design.impl;

import com.java.design.MyPredicate;
import com.java.entity.Employee;

/**
 * @author 风往西边吹丶
 * @create 2019-05-29 22:54
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
