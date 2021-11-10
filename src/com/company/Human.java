package com.company;
import java.util.Scanner;

public class Human {
    String surname;
    Address home_adress = new Address();
    /*Конструктор записей*/
    public Human(String surname, String street, int house){
        this.surname = surname;
        this.home_adress.house = house;
        this.home_adress.street = street;
    }
    /*Вложенный класс Адрес*/
    public class Address{
        String street;
        int house;
    }

}
