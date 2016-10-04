package com.wang.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by wangshuyang on 16/9/19.
 * 完成以下功能:
 * 1.通过Collections.sort()方法对Integer泛型进行排序
 * 2.对String泛型的List进行排序
 * 3.对其他类型泛型的List进行排序,以Student为例
 */
public class CollectionTest {

    /**
    1.通过Collections.sort()方法对Integer泛型进行排序
     创建一个Integer泛型的List,在其中插入10个100以内不重复的随机整数
     调用Collections.sort()方法进行排序
     */
    public void testSort1(){
        List<Integer> integerList = new ArrayList<Integer>();
        //创建一个Integer泛型的List,在其中插入10个100以内不重复的随机整数
        Random random = new Random();
        Integer k;
        for(int i = 0; i < 10; i++){
            do {
                k = random.nextInt(100);
            } while(integerList.contains(k));
            integerList.add(k);
            System.out.println("成功添加整数: " + k);
        }
        System.out.println("--------------这是分界线(排序前)------------");
        for (Integer integer : integerList) {
            System.out.println("元素: " + integer);
        }
        Collections.sort(integerList);
        System.out.println("--------------这是分界线(排序后)------------");
        for (Integer integer : integerList) {
            System.out.println("元素: " + integer);
        }
    }

    /**
     * 2.对String泛型的List进行排序
     * 创建String泛型的List,添加三个混乱的String元素
     * 调用sort()方法进行排序,并且输出排序的结果
     */
    public void testSort2(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("wangshuyang");
        stringList.add("aiwangyashu");
        stringList.add("zhaoshangjun");
        System.out.println("--------------这是分界线(排序前)------------");
        for (String string : stringList) {
            System.out.println("元素: " + string);
        }
        Collections.sort(stringList);
        System.out.println("--------------这是分界线(排序后)------------");
        for (String string : stringList) {
            System.out.println("元素: " + string);
        }
    }

    /**
     * 对String泛型的List进行排序,但是要随机生成字符串
     */
    public void testSort3(){
        List<String> stringList = new ArrayList<String>();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String string;
        for(int j = 0; j < 10; j++) {
            do {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 10; i++) {
                    int number = random.nextInt(str.length());
                    sb.append(str.charAt(number));
                }
                string = sb.toString();
            } while(stringList.contains(string));
            stringList.add(string);
            System.out.println("成功添加: " + string);
        }
        System.out.println("--------------这是分界线(排序前)------------");
        for (String strings:stringList) {
            System.out.println("元素: " + strings);
        }
        Collections.sort(stringList);
        System.out.println("--------------这是分界线(排序后)------------");
        for (String strings : stringList) {
            System.out.println("元素: " + strings);
        }
    }

    /**
     * 3.对其他类型泛型的List进行排序,以Student为例
     */
    public void testSort4(){
        List<Student> studentList = new ArrayList<Student>();
        Random random = new Random();
        studentList.add(new Student(random.nextInt(1000) + "" , "王舒洋"));
        studentList.add(new Student(random.nextInt(1000) + "" , "王雅姝"));
        studentList.add(new Student(random.nextInt(1000) + "" , "赵尚君"));
        System.out.println("--------------这是分界线(排序前)------------");
        for (Student student : studentList) {
            System.out.println("学生: " + student.id + student.name);
        }
        Collections.sort(studentList);
        System.out.println("--------------这是分界线(排序后)------------");
        for (Student student : studentList) {
            System.out.println("学生: " + student.id + student.name);
        }
        System.out.println("--------------这是分界线(按照姓名排序前)------------");
        for (Student student : studentList) {
            System.out.println("学生: " + student.id + student.name);
        }
        Collections.sort(studentList,new StudentComparator());
        System.out.println("--------------这是分界线(按照姓名排序后)------------");
        for (Student student : studentList) {
            System.out.println("学生: " + student.id + student.name);
        }
    }

    public static void main(String[] args) {
        CollectionTest ct = new CollectionTest();
//        ct.testSort1();
//        ct.testSort2();
//        ct.testSort3();
        ct.testSort4();
    }
}
