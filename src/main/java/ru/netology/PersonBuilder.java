package ru.netology;

import java.util.OptionalInt;

public class PersonBuilder {
    protected String name, surname, city;
    protected OptionalInt age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age.getAsInt();
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        this.age = OptionalInt.of(age);
        return this;
    }

    public Person build() throws IllegalStateException {
        if (surname == null || name == null) throw new IllegalStateException("Не все данные были указаны!");
        return new Person(name, surname, city, age.getAsInt());
    }
}
