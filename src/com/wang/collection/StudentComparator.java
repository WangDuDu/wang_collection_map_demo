package com.wang.collection;

import java.util.Comparator;

/**
 * Created by wangshuyang on 16/9/20.
 */
public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
