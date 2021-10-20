package com.company;
import java.util.Scanner;

public class Quadratic_equation { //Поля для задания квадратного уравнения
    public static int a;
    public static int x;
    public static int b;
    public static int c;



    public Quadratic_equation(int a, int b, int c){ //Конструктор квадратного уравнения
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void show_equation(){

        System.out.println(a+"x^2"+"+"+b+"x"+"+"+c+"=0");
        System.out.println("Проверка гита");
    }


    public static class Determinant{ //Вложенный класс для нахождения детерминанта
        int determinant;
        void determinant_finder(){
            determinant = (int) (Math.pow(b,2)-4*a*c);
            //где-то в этом месте я похоронил свои нервные клетки...
        }

        void show_determinant(){ //Просто вывод детерминанта для отладки
            System.out.println("Determinant: "+determinant);
        }
    }


}
