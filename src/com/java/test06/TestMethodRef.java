package com.java.test06;


import com.java.entity.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用
 * <p>
 * 三种：
 * 对象:: 实例方法名
 * 类:: 静态方法名
 * 类:: 实例方法名
 * <p>
 * 注意事项：1. 调用方法的参数列表于返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 2.   (x,y) -> x.equals(y);
 * String::equals;  符合这样的才行
 * <p>
 * <p>
 * 二、构造器引用
 * <p>
 * ClassName::new
 *
 * 三、数组引用
 * Type::new
 */


public class TestMethodRef {

    //对象:: 实例方法名
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> consumer = ps::println;


        Consumer<String> consumer2 = System.out::println;
        consumer.accept("adfadf");

    }

    @Test
    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }


    // 类::静态方法名
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compareTo;
        com1.compare(13, 23);


    }

    // 类:: 实例方法名
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;

    }


    // 构造器引用
    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        Employee employee = sup2.get();
        System.out.println(employee);

        //

        Function<Integer,Employee> fun2 = Employee::new;
        Employee employee1 = fun2.apply(101);
        System.out.println(employee1);

    }


    // 数组引用
    @Test
    public void test6(){
        Function<Integer ,String[]> fun = (x) ->new String[x];
        String[] strings = fun.apply(10);
        System.out.println(strings.length);

        Function<Integer ,String[]> fun2 = String[]::new;
        String[] apply = fun2.apply(20);


    }



}
