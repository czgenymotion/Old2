package com.qianfeng.helper;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class User{
    private String name;
    private String age;
    private String sex;

    @Override
    public String toString(){
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }
}
