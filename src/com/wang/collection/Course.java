package com.wang.collection;

import java.util.Objects;

/**
 * 课程类
 * Created by wangshuyang on 16/7/28.
 */
public class Course {

    public String id;

    public String name;

    public Course(String id, String name){
        this.id = id;
        this.name = name;

    }
    public Course(){}

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;

        }
        if(!(obj instanceof Course)){
            return false;
        }
        Course course = (Course) obj;
        if(this.name == null){
            if(course.name == null) {
                return true;
            } else{
                return false;
            }
        } else{
            if(this.name.equals(course.name)){
                return true;
            } else{
                return false;
            }
        }
    }
}
