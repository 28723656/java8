package com.java.test01;

import com.java.design.MyPredicate;
import com.java.design.impl.FilterEmployeeByAge;
import com.java.design.impl.FilterEmployeeBySalary;
import com.java.entity.Employee;
import org.junit.Test;

import java.util.*;

/**
 * @author 风往西边吹丶
 * @create 2019-05-29 22:25
 */
public class TestLambda {

    // 原来的匿名内部类
    @Test
    public void test1() {

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);

    }


    // Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);

    }


    List<Employee> employees = Arrays.asList(
            new Employee(101,"张三", 18, 999.99),
            new Employee(102,"李四", 38, 6999.99),
            new Employee(103,"王五", 68, 3999.99),
            new Employee(104,"赵六", 28, 9999.99),
            new Employee(105,"田七", 8, 1999.99)
    );

    // 需求1：获取当前公司中年龄大于35岁的员工信息
    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test3() {
        List<Employee> employees = filterEmployees(this.employees);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    // 需求2：获取当前公司中工资大于5000的员工信息，重复上面的


    // 优化方式一，策略设计模式

    @Test
    public void test4(){
        List<Employee> list = filterEmployee(employees,new FilterEmployeeByAge());
        for(Employee employee : list){
            System.out.println(employee);
        }

        System.out.println("-------------------------------------------");

        List<Employee> list2 = filterEmployee(employees,new  FilterEmployeeBySalary());
        for(Employee employee : list2){
            System.out.println(employee);
        }


    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if(mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }


    // 优化方式二：匿名内部类

    @Test
    public void test5(){
        List<Employee> list = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });

        for (Employee employee : list){
            System.out.println(employee );
        }

    }

    // 优化方式三： Lambda表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(this.employees, (e) -> e.getSalary() <= 5000);
        list.forEach(System.out::println);
    }

    @Test
    public void test7(){
        employees.stream()
                .filter((e) ->e.getSalary() >=5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-------------------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }


}
