package com.company;

import java.util.Scanner;

public class Human {
    String surname;
    int objects_count;
    Human[] Humans = new Human[objects_count];

    public Human(String forname){
        this.surname = forname;
    }

    public void HumanSurnameFind(String surname_to_find, Human[] humans_surnames){
        System.out.println("Результаты поиска по фамилии: ");
        for (int i = 0; i<humans_surnames.length; i++){
            if(surname_to_find==humans_surnames[i].surname){
                System.out.println("Найден результат по фамилии: "+surname_to_find+" его номер: "+(i+1));
            }
        }
    }

    public void CreateHumanDatabase(int objects_count){
        System.out.println("Введите данные про людей: ");
        for(int i = 0; i<Humans.length; i++){
            System.out.println("Данные - Фамилия, Адрес-улица, Адрес - дом");
            System.out.println("Человек №"+(i+1));
            String forname_to_enter;
            Scanner forname_enter = new Scanner(System.in);
            forname_to_enter = forname_enter.nextLine();
            Humans[i] = new Human(forname_to_enter);
        }
    }
}
