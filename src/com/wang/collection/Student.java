package com.wang.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 学生类
 * Created by wangshuyang on 16/7/28.
 */
public class Student implements Comparable<Student> {

    public String id;

    public String name;

    public Set<Course> course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public Student (String id, String name){
        this.id = id;
        this.name = name;
        this.course = new HashSet<Course>();
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
