package com.java.design.impl;

import com.java.design.MyPredicate;
import com.java.entity.Employee;

/**
 * @author 风往西边吹丶
 * @create 2019-05-29 22:48
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >=35;
    }
}
