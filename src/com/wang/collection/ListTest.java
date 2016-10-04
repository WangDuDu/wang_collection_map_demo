package com.wang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 备选课程类
 * Created by wangshuyang on 16/7/28.
 */
public class ListTest {

    /**
     * 用于存放备选课程的List
     */

    public List courseToSelect;

    public ListTest(){
        this.courseToSelect = new ArrayList<>();
    }

    /**
     * 用于往coursesToSelect中添加备选课程
     */
    public void testAdd(){
        //创建一个课程对象,并通过调用add方法,添加到备选课程List中
        Course cr1 = new Course("1","数据结构");
        courseToSelect.add(cr1);
        Course temp = (Course)courseToSelect.get(0);
        System.out.println("添加了课程: " + temp.id + ":" + temp.name);

        Course cr2 = new Course("2", "C语言");
        courseToSelect.add(0, cr2);
        Course temp2 = (Course)courseToSelect.get(0);
        System.out.println("添加了课程: " + temp2.id + ":" + temp2.name);

        courseToSelect.add(cr1);
        Course temp1 = (Course)courseToSelect.get(2);
        System.out.println("添加了课程: " + temp1.id + ":" + temp1.name);

        //以下方法会抛出数组下标越界异常
        // Course cr3 = new Course("3", "离散数学");
        // courseToSelect.add(4,cr3);

        Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
        courseToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) courseToSelect.get(3);
        Course temp4 = (Course) courseToSelect.get(4);

        System.out.println("添加了两门课程: " + temp3.id + ":" + temp3.name
            + ";" + temp4.id + ":" + temp4.name);

        Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
        courseToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course)courseToSelect.get(2);
        Course temp6 = (Course)courseToSelect.get(3);
        System.out.println("添加了两门课程: " + temp5.id + ":" + temp5.name
            + ";" + temp6.id + ":" + temp6.name);
    }

    /**
     * 取得List中元素的方法
     */
    public void testGet(){
        int size = courseToSelect.size();
        System.out.println("有如下课程待选: ");
        for(int i = 0; i < size; i++){
            Course cr = (Course) courseToSelect.get(i);
            System.out.println("课程: " + cr.id + ":" +cr.name);
        }

    }

    /**
     * 通过迭代器来遍历List
     */
    public void testIterrator(){
        //通过迭代器访问
        Iterator it = courseToSelect.iterator();
        System.out.println("有如下课程待选(通过迭代器访问): ");
        while (it.hasNext()){
            Course cr = (Course) it.next();
            System.out.println("课程: " + cr.id + ":" +cr.name);
        }
    }

    /**
     * 通过for each方法访问集合元素
     */
    public void testForEach(){
        System.out.println("有如下课程待选(通过for each访问): ");
        for(Object obj : courseToSelect){
            Course cr = (Course) obj;
            System.out.println("课程: " + cr.id + ":" +cr.name);
        }
    }

    /**
     * 修改List中的元素
     */
    public void teatModify(){
        courseToSelect.set(4,new Course("7","毛概"));
    }

    /**
     * 删除List中的元素
     */
    public void testRemove(){
//      Course cr = (Course) courseToSelect.get(4);
//      System.out.println("我是课程:" + cr.id + ":" + cr.name + ",我即将被删除");
        System.out.println("删除4位置和5位置的元素");
        Course[] courses = {(Course)courseToSelect.get(4),(Course)courseToSelect.get(5)};
        courseToSelect.removeAll(Arrays.asList(courses));
//      courseToSelect.remove(cr);
        System.out.println("成功删除课程!");
        testForEach();
    }

    /**
     * 往List中添加奇怪的东西
     */
    public  void testType(){
        System.out.println("可以添加一个字符串吗?");
        courseToSelect.add("我只是一个字符串");
    }

    public static void main(String[] args){
        ListTest lt = new ListTest();
        lt.testAdd();
//        lt.testType();
//        lt.testForEach();
        lt.testGet();
        lt.testIterrator();
        lt.testForEach();
        lt.teatModify();
        lt.testForEach();
        lt.testRemove();
    }
}

