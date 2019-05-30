package com.java.test05;

import com.sun.codemodel.internal.JForEach;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的4大核心函数式接口
 * <p>
 * Consumer<T>    消费形接口
 * void accept(T t);
 * <p>
 * Supplier<T>    供给型接口
 * T get();
 * <p>
 * Function(T,R)  : 函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T>  :  断言型接口
 * boolean test(T t);
 */
public class TestLambda3 {

    // Consumer<T>
    @Test
    public void test1() {
        happy(10000, (money) -> System.out.println("消费" + money + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    // Supplier<T>
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        numList.forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }


    // Function<T,R>
    @Test
    public void test3() {
        String newStr = strHandle("\t\t\t\t 去除空格   ", str -> str.trim());
        System.out.println(newStr);

        String s = strHandle("截取我这个字", str -> str.substring(2, 3));
        System.out.println(s);

    }

    //需求，用于处理字符串
    public String strHandle(String str, Function<String, String> function) {
        return function.apply(str);
    }



    //Predicate<T>
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello","abcd","dfasdf","12");
        List<String> stringList = filterStr(list, s -> s.length() > 3);

        stringList.forEach(System.out::println);
    }

    // 需求：将满足条件的字符串放入集合中
    public List<String > filterStr(List<String> list, Predicate<String> predicate){
        List<String> strList = new ArrayList<>();

        for(String str : list){
            if(predicate.test(str)){
                strList.add(str);
            }
        }
        return strList;

    }


}
