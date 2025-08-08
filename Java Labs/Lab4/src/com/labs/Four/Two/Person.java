package com.labs.Four.Two;
public class Person {
    private String name;
    private float age;

    public Person(String name, float age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public float getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(float age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}
