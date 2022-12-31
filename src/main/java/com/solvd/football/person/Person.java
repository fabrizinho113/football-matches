package com.solvd.football.person;

public abstract class Person {

    protected String name;
    protected int age;
    protected String fitness;

    public Person(){

    }

    public Person(String name, int age, String fitness) {
        this.name = name;
        this.age = age;
        this.fitness = fitness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public abstract void physicalEffort();

}
