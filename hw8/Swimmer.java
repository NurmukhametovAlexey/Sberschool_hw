package ru.sbrf.lesson11.hw8;

import java.util.function.Consumer;

public class Swimmer {
    String name;
    Integer age;

    public Swimmer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void swim(Consumer<String> c) {
        c.accept(name);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
