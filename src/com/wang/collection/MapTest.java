package com.wang.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wangshuyang on 16/8/9.
 */
public class MapTest {

    /**
     * 用来承装学生类型的对象
     * @param args
     */
    public Map<String, Student> student;

    /**
     * 在构造器中初始化student属性
     */
    public MapTest(){
        this.student = new HashMap<String, Student>();
    }

    /**
     * 测试添加:输入学生ID,判断是否被占用
     * 若未被占用,则输入姓名,创建新的学生对象
     * 添加到student中
     */
    public void testPut(){
        //创建一个Scanner对象,用来获取输入的学生ID和姓名
        Scanner console = new Scanner(System.in);
        int i = 0;
        while(i < 3){
            System.out.println("请输入学生的ID");
            String ID = console.next();
            //判断ID是否被占用
            Student st = student.get(ID);
            if(st == null){
                //提示输入学生的姓名
                System.out.println("请输入学生的姓名");
                String name = console.next();
                //创建新的学生对象
                Student newStudent = new Student(ID, name);
                //通过调用put方法往student中添加
                student.put(ID, newStudent);
                System.out.println("成功添加学生: " + student.get(ID).name);
                i++;
            }else {
                System.out.println("该学生ID已经被占用!");
                continue;
            }
        }

    }

    /**
     * 测试Map的keySet方法
     */
    public void testKeySet(){
        //通过KeySet方法,返回Map中的多有键的Set集合
        Set<String> keySet = student.keySet();
        // 取得student的容量
        System.out.println("总共有" + student.size() + "个学生");
        //遍历keySet.取得每一个键,再调用get方法取得每个键对应的value值
        for (String stuId: keySet) {
            Student st = student.get(stuId);
            if (st != null) {
                System.out.println("学生: " + st.name);
            }

        }
    }

    /**
     * 测试删除Map中的映射
     */
    public void testRemove(){
        //获取从键盘输入的待删除的学生ID字符串
        Scanner console = new Scanner(System.in);
        while (true){
            //提示输入待删除的学生的ID
            System.out.println("请输入要删除的学生的ID: ");
            String ID = console.next();
            //判断ID是否有对应的学生对象
            Student st = student.get(ID);
            if(st == null){
                System.out.println("该ID不存在");
                continue;
            }
            student.remove(ID);
            System.out.println("成功删除学生: " + st.name);
            break;

        }
    }

    /**
     * 通过put方法来修改Map中已有的映射
     */
    public void testModify(){
        //提示输入要修改的学生ID
        System.out.println("请输入要修改的学生ID");
        //创建一个Scanner对象,并从键盘上获取学生的ID字符串
        Scanner console = new Scanner(System.in);
        while (true){
            //获取从键盘上输入的学生ID
            String stuID = console.next();
            Student st = student.get(stuID);
            if (st == null){
                System.out.println("该ID不存在请重新输入!!!!");
                continue;
            }
            //提示输入的学生ID对应的姓名
            System.out.println("学生ID:" + st.id + "对应的学生的姓名为:" + st.name);
            //提示输入新的学生姓名来修改已有的映射
            System.out.println("请输入新的姓名!!!!");
            String name = console.next();
            Student newSudent = new Student(stuID,name);
            student.put(stuID,newSudent);
            System.out.println("修改成功!!!");
            break;
        }
    }

    /**
     * 通过entrySet方法来遍历Map
     */
    public void testEntrySet(){
        //通过entrySet方法来返回Map中所有的键值对
        Set<Map.Entry<String, Student>> entrySet = student.entrySet();
        for (Map.Entry<String, Student> entry : entrySet) {
            System.out.println("取得键: " + entry.getKey());
            System.out.println("对应的值为: " + entry.getValue().name);
        }
    }

    /*
    测试Map中是否包含Key和value值
     */
    public void teatContainsKeyOrValue(){
        //提示用户输入
        System.out.println("请输入要查询的学生ID:");
        Scanner console = new Scanner(System.in);
        String stuId = console.next();
        //用containsKey()方法来检查Key值
        System.out.println("您输入的ID字符串是否存在: " + student.containsKey(stuId));
        if(student.containsKey(stuId))
            System.out.println("对应的学生姓名为: " + student.get(stuId).name);
        //提示用户输入
        System.out.println("请输入要查询的学生姓名");
        String stuName = console.next();
        //用containsValue()方法来检查Value值
        if(student.containsValue(new Student(null,stuName)))
            System.out.println("在学生映射表中确实包含学生: " + stuName);
        else
            System.out.println("查无此学生!");
    }


    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
//        mt.testRemove();
//        mt.testEntrySet();
//        mt.testModify();
//        mt.testEntrySet();
        mt.teatContainsKeyOrValue();
    }
}
