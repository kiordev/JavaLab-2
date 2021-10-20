package com.company;
import java.lang.String;
import java.lang.System;
import java.util.Scanner;

/*
 * Лабораторная работа №2 студента группы ВТ-19 (2021)
 *
 * Дисциплина: Кросс-платформенное программирование на Java
 *
 * Александр Киор, Мариуполь 2021
 */

public class Main {

    /* Task List */
    static void Task_Two(){
        int fib_nums; //Примитивный UI
        Scanner fib_nums_val = new Scanner(System.in);
        System.out.println("Генератор чисел Фибоначчи");
        System.out.println("Введите количество чисел для генерации:");
        fib_nums = fib_nums_val.nextInt();
        System.out.println("Введенное значение: " + fib_nums);
        int[] fibonachi_nums = new int[fib_nums];

        fibonachi_nums[0] = 0; //Задаем первые 2 аргумента
        fibonachi_nums[1] = 1;
        for(int i = 2; i<fibonachi_nums.length; i++){ //Алгоритм генирации числа
            fibonachi_nums[i] = fibonachi_nums[i-1] + fibonachi_nums[i-2];
        }
        System.out.println("Ряд чисеил Фибонначи размерностью: "+fib_nums); //Вывод массива
        for(int i = 0; i<fibonachi_nums.length; i++){
            System.out.println(fibonachi_nums[i]+" ");
        }



    } //Второе задание
    static void Task_Three(){} //Третье задание //НЕ ГОТОВО
    static void Task_Four(){} //Четвертое задание //НЕ ГОТОВО
    static void Task_Five(){
        /*Значения для конструктора уравнения*/
        int a;
        Scanner a_num = new Scanner(System.in);
        int b;
        Scanner b_num = new Scanner(System.in);
        int c;
        Scanner c_num = new Scanner(System.in);
        /*Запуск процеса решения квадратного уравнения*/
        System.out.println("Решение квадратных уравнений");
        System.out.println("Введите a b c: ");
        a = a_num.nextInt();
        b = b_num.nextInt();
        c = c_num.nextInt();
        Quadratic_equation quadratic_equation = new Quadratic_equation(a,b,c);
        Quadratic_equation.Determinant determinant = new Quadratic_equation.Determinant();
        quadratic_equation.show_equation();
        determinant.determinant_finder();
        determinant.show_determinant();
        /*Нахождение корней*/
        double x_1;
        double x_2;
        if(determinant.determinant>0){ //Если дискриминант больше нуля
            x_1 = (double) ((-quadratic_equation.b+Math.sqrt(determinant.determinant))/(2*quadratic_equation.a));
            x_2 = (double) ((-quadratic_equation.b-Math.sqrt(determinant.determinant))/(2*quadratic_equation.a));
            System.out.println("Корни уравнени:");
            System.out.println("x1 = "+x_1);
            System.out.println("x2 = "+x_2);
        }
        else if(determinant.determinant==0){ //Если дискриминант равен нулю
            x_1 = (double) (-quadratic_equation.b/(2*quadratic_equation.a));
            System.out.println("Корни уравнени:");
            System.out.println("x1 = "+x_1);
            System.out.println("x2 = отсутствует по математическим причинам");
        }
        else if(determinant.determinant<0){ //Если дискриминант меньше нуля
            System.out.println("У уравнения нет корней");
        }

    } //Пятое задание
    static void Task_Six(){
    } //Шестое задание
    static void Task_Seven(){
    } //Седьмое задание
    static void Task_Eight(){
        /* Аргументы для ввода */
        double x;
        Scanner x_num = new Scanner(System.in);
        double begin;
        Scanner begin_num = new Scanner(System.in);
        double end;
        Scanner end_num = new Scanner(System.in);
        double step;
        Scanner step_num = new Scanner(System.in);

        int user_choose = 0;
        Scanner user_choose_num = new Scanner(System.in);
        System.out.println("Функциональный калькулятор");
        /* Ввод аргументов */
        System.out.println("Введите х: ");
        x = x_num.nextDouble();
        System.out.println("Введите begin: ");
        begin = begin_num.nextDouble();
        System.out.println("Введите end: ");
        end = end_num.nextDouble();
        System.out.println("Введите step: ");
        step = step_num.nextDouble();
        Calculate x_arg = new Calculate(x,begin,end,step);

        System.out.println("Введите номер фукнции 1-2: ");
        user_choose = user_choose_num.nextInt();
        if(user_choose==1){
            x_arg.function_one();
        }
        else if(user_choose==2){
            x_arg.function_two();
        }
        else{
            System.out.println("Вы ввели что-то не так");
        }


    } // Восьмое задание
    /* Task List */
    public static void main(String[] args) {
        int global_user_choose = 0; //Глобальная переменная для выбора
        Scanner global_user = new Scanner(System.in);

        System.out.println("Лабораторная работа №2");
        boolean ProgramWorking = true;
        while(ProgramWorking == true){
            System.out.println("---------------------");
            System.out.println("2 - Второе задание");
            System.out.println("3 - Третье задание");
            System.out.println("4 - Четвертое задание");
            System.out.println("5 - Пятое задание");
            System.out.println("6 - Шестое задание");
            System.out.println("7 - Седьмое задание");
            System.out.println("8 - Восьмое задание");
            System.out.println("Введите номер задания: ");
            global_user_choose = global_user.nextInt();

            if(global_user_choose == 2 ){
                Task_Two();
            }
            else if(global_user_choose == 3){
                Task_Three();
            }
            else if(global_user_choose == 4){
                Task_Four();
            }
            else if(global_user_choose == 5){
                Task_Five();
            }
            else if(global_user_choose == 6){
                Task_Six();
            }
            else if(global_user_choose == 7){
                Task_Seven();
            }
            else if(global_user_choose == 8){
                Task_Eight();
            }
            else{
                System.out.println("Ошибка, введите верное значение");
            }
        }


    }


}
