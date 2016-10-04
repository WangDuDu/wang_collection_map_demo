package com.wang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangshuyang on 16/8/8.
 */
public class SetTest {

    public List<Course> courseToSelect;

    private Scanner console;

    public Student student;

    public SetTest(){
        courseToSelect = new ArrayList<Course>();
        console = new Scanner(System.in);
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

//        courseToSelect.add(cr1);
//        Course temp1 = (Course)courseToSelect.get(2);
//        System.out.println("添加了课程: " + temp1.id + ":" + temp1.name);

        //以下方法会抛出数组下标越界异常
//         Course cr3 = new Course("3", "离散数学");
//         courseToSelect.add(4,cr3);

        Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
        courseToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) courseToSelect.get(2);
        Course temp4 = (Course) courseToSelect.get(3);

//        System.out.println("添加了两门课程: " + temp3.id + ":" + temp3.name
//                + ";" + temp4.id + ":" + temp4.name);

        Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
        courseToSelect.addAll(4,Arrays.asList(course2));
        Course temp5 = (Course)courseToSelect.get(4);
        Course temp6 = (Course)courseToSelect.get(5);
//        System.out.println("添加了两门课程: " + temp5.id + ":" + temp5.name
//                + ";" + temp6.id + ":" + temp6.name);
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
     * 打印输出学生所选的课程!
     */
    public void testForEachForSet(Student student){
        System.out.println("共选择了: " + student.course.size() + "门课程!");
        for(Course cr : student.course){
            System.out.println("选择了课程: " + cr.id + ":" + cr.name);
        }
    }

    /**
     * 测试List的contains方法
     */
    public void testListContains(){
        //取出备选课程中的第0个元素
        Course course = courseToSelect.get(0);
        //打印并输出courseToSelect是否包含course对象
        System.out.println("取得课程: " + course.name);
        System.out.println("备选课程中是否含有课程: " + course.name + courseToSelect.contains(course));
        //提示从键盘上输入课程名称
        System.out.println("请输入课程名称: ");
        String name = console.next();
        //新创建一个course2对象,使其属性与course完全一样
        Course course2 = new Course();
        course2.name = name;
        System.out.println("取得课程: " + course2.name);
        System.out.println("备选课程中是否含有课程: " + course2.name + courseToSelect.contains(course2));
        //通过indexOf方法来获取某元素的索引位置
        if(courseToSelect.contains(course2))
            System.out.println("课程:" + course2.name + "位置为:" + courseToSelect.indexOf(course2));
    }

    /**
     * 创建一个学生对象并选课
     */
    public void createStudentAndSelectCourse(){
        //创建一个学生对象
        student = new Student("1", "小明");
        System.out.println("欢迎学生:" + student.name + "选课!");
        //创建一个Scanner对象,用来接收从键盘输入的课程ID
        Scanner console = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            System.out.println("请输入课程ID");
            String courseId = console.next();
            for(Course cr : courseToSelect){
                if(cr.id.equals(courseId)){
                    student.course.add(cr);
                    //Set中,添加某个对象,无论添加多少次,最终只保留一个该对象(的引用),并且,保留的第一次添加的那一个
//                    student.course.add(null);
//                    student.course.add(cr);
                }
            }
        }

    }

    /**
     * 测试Set的contains方法
     */
    public void testSetContains(){
        //提示输入课程名称
        System.out.println("请输入学生已选的课程名称: ");
        String name = console.next();
        Course course2 = new Course();
        course2.name = name;
        System.out.println("取得课程: " + course2.name);
        System.out.println("备选课程中是否含有课程: " + course2.name + student.course.contains(course2));

    }

    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testListContains();
        st.testForEach();
//        st.createStudentAndSelectCourse();
//        st.testSetContains();

//        //创建一个学生对象
//        Student student = new Student("1", "小明");
//        System.out.println("欢迎学生:" + student.name + "选课!");
//        //创建一个Scanner对象,用来接收从键盘输入的课程ID
//        Scanner console = new Scanner(System.in);
//
//        for(int i = 0; i < 3; i++){
//            System.out.println("请输入课程ID");
//            String courseId = console.next();
//            for(Course cr : st.courseToSelect){
//                if(cr.id.equals(courseId)){
//                    student.course.add(cr);
//                    //Set中,添加某个对象,无论添加多少次,最终只保留一个该对象(的引用),并且,保留的第一次添加的那一个
////                    student.course.add(null);
////                    student.course.add(cr);
//                }
//            }
//        }
//
//        st.testForEachForSet(student);
    }
}
