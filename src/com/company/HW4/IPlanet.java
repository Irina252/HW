package com.company.HW4;

public interface IPlanet {

    double getG();
}

abstract class BasePlanet implements IPlanet {
    private String name;
    private long weight;
    private long age;

    public BasePlanet(String name, long weight, long age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}

class Earth extends BasePlanet {

    public Earth(String name, long weight, long age) {
        super(name, weight, age);
    }

    @Override
    public double getG() {
        return 9.64;
    }
}

class Mars extends BasePlanet {

    public Mars(String name, long weight, long age) {
        super(name, weight, age);
    }

    @Override
    public double getG() {
        return 6.7;
    }
}

class Main {

    public static void main(String[] args) {

    }
}