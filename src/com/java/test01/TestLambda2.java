package com.java.test01;

import com.java.design.MyPredicate;
import com.java.design.impl.FilterEmployeeByAge;
import com.java.design.impl.FilterEmployeeBySalary;
import com.java.entity.Employee;
import com.java.test03.MyFun;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一、Lambda表达式的基础语法：   ->
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：表达式中所需要执行的功能
 */


/**
 *  语法格式一：无参数，无返回值
 *    () -> System.out.println("Hello World");
 *
 *
 *  语法格式二： 有一个参数，并且无返回值
 *      (x) -> System.out.println(x);
 *
 *  语法格式三： 若只有一个参数，参数的小括号可以省略不写
 *          x -> System.out.println(x);
 *
 *  语法格式四： 又两个及以上的参数，并且有多条语句
 *            Comparator<Integer> com = (x,y) ->{
 *             System.out.println("函数式接口");
 *             return Integer.compare(x,y);
 *         };
 *
 * 语法格式无： 如果只有一条语句，return和大括号可以省略不写
 *                Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
 *
 *
 * 语法格式六： 参数列表的数据类型可以省略不写，如果写了就都要写
 *              (Integer x,Integer y) -> Integer.compare(x,y);
 *
 *
 *
 *    二、Lambda表达式需要 “函数式接口”的支持
 *    函数式接口： 接口中只有一个抽象方法的接口，成为函数式接口，可以使用注解
 *      @FunctionalInterface    来修饰
 */

public class TestLambda2 {


    @Test
    public void test1(){

        int num = 0;   // jdk1.7之前，必须是final,现在1.8实际还是final，只是不用写final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,World"+ num);
            }
        };
        r.run();

        System.out.println("-----------------------");

        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();


    }




    @Test
    public void test2(){

        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("测试Hello World");
    }


    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) ->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }


    @Test
    public void test5(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }



    // 需求： 对一个数进行运算
    @Test
    public void test6(){
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        System.out.println("---------------");

        System.out.println(operation(200,(y)->y+200   ));

    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }


}
