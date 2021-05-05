package org.home.entity;

import com.opencsv.bean.CsvBindByName;

public class Passenger {

    //@CsvBindByName(column = "Survived")
    private int survived;

    //@CsvBindByName(column = "Name")
    private String name;

    //@CsvBindByName(column = "Sex")
    private String sex;

    //@CsvBindByName(column = "Age")
    private int age;

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
