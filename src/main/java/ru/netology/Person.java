package ru.netology;

import java.util.OptionalInt;

public class Person {
    protected String name, surname, city;
    protected OptionalInt age;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, String city, int age) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAddress() {
        if (city != null) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public OptionalInt getAge() {
        if (age == null) return age.empty();
        return age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age.getAsInt() +
                '}';
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setCity(city)
                .setAge(age.getAsInt() - 18);
    }
}
