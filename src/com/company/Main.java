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
    static void Task_Three(){
        System.out.println("Генератор треугольника Паскаля");
        PascalsTriangle triangle = new PascalsTriangle(6);
        triangle.generatePascalsTriangle();
    } //Третье задание
    static void Task_Four(){
        Complex z = new Complex(3, 2);
        z = z.div(z);
        System.out.println(z);
        System.out.println();
        Complex u = new Complex(0, 0);
        Complex v = new Complex(1, 0);
        Complex a = u.rotate(v, Math.PI * 1.0);
        Complex b = v.rot90().rot90();
        System.out.println(a);
        System.out.println(b);
    } //Четвертое задание
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
        int players_val;
        Scanner player_val_enter = new Scanner(System.in);
        System.out.println("Игра к кости");
        System.out.println("Введите количество игроков для игры:");
        players_val= player_val_enter.nextInt();

        /*Создание массива со списком игроков*/
        Player[] game_players = new Player[players_val];

        /*Создание игроков для игры в кубики*/
        for(int i = 0; i < game_players.length; i++){
            String players_name;
            Scanner player_name_enter = new Scanner(System.in);
            System.out.println("Введите имя игрока номер - " + (i+1));
            players_name = player_name_enter.nextLine();
            game_players[i] = new Player(players_name);
        }

        /*Вывод списка всех игроков*/
        System.out.println("Список всех игроков: ");
        for(int i = 0; i < game_players.length; i++){
            System.out.println("Игрок номер "+ (i + 1) + ":" + game_players[i].player_name);
        }

        /*Создание кубиков*/
        int cube_val;
        Scanner cube_val_enter = new Scanner(System.in);
        System.out.println("Введите количество кубиков для игры: ");
        cube_val = cube_val_enter.nextInt();

        if(cube_val<0){
            System.out.println("Critical Error");
        }
        else{
            /*Создание массива из K кубиков*/
            Player.GameCube[] gamecubes = new Player.GameCube[cube_val];
            /*Создание объектов кубиков*/
            for(int i = 0; i < gamecubes.length; i++){
                gamecubes[i] = new Player.GameCube();
            }

            /*Основной цикл игры*/
            boolean GameIsOne = true;
            int counter = 1;
            while(GameIsOne==true){
                System.out.println("---------------------------------");
                System.out.println("Раунд номер - "+counter);
                System.out.println("---------------------------------");
                for(int i = 0; i < game_players.length; i++){
                    System.out.println("Очередь игрока: "+game_players[i].player_name);
                    for(int j = 0; j <  gamecubes.length; j++){
                        game_players[i].GameCubeThrow();
                        game_players[i].main_points += gamecubes[j].after_throw_value;
                    }
                    System.out.println("Результат игрока "+game_players[i].player_name+":"+game_players[i].main_points);
                }
                /*Пузырьковая сортировка результатов после игрового этапа*/
                for (int i = 0; i < game_players.length; i++) {
                    for (int j = 0; j < game_players.length-1; j++) {
                        if (game_players[j].main_points > game_players[j+1].main_points) {
                            Player b = game_players[j];
                            game_players[j] = game_players[j + 1];
                            game_players[j+1] = b;
                        }
                    }
                }
                game_players[game_players.length-1].value_of_wins+=1; //Прибавления побед победителю раунда
                /*Вывод количества побед*/
                System.out.println("---------------------------------");
                System.out.println("Количество побед: ");
                for(int i = 0; i < game_players.length; i++){
                    System.out.println(game_players[i].player_name+" : "+game_players[i].value_of_wins);
                }
                /*Вывод рейтинга игроков, первое место = +1 победа*/
                System.out.println("---------------------------------");
                System.out.println("Рейтинг игроков после раунда:"+counter);
                for(int i = 0; i < game_players.length; i++){
                    System.out.println("Место №"+(i+1)+" "+game_players[i].player_name);
                }
                game_players[0].value_of_wins+=1;
                System.out.println("---------------------------------");

                /*Обнуление количества очков после раунда*/
                for(int i = 0; i<game_players.length; i++){
                    game_players[i].main_points = 0;
                }
                /*Вычисление победителя*/
                for(int i = 0; i<game_players.length; i++){
                    if(game_players[i].value_of_wins==7){
                        System.out.println("Игрок номер: "+game_players[i].player_name+" -победитель");
                        GameIsOne=false;
                    }
                }
                counter++;
            }
        }
    } //Шестое задание
    static void Task_Seven(){
        System.out.println("Седьмое задание: ");
        int humans_array_value;
        Scanner enter_humans_array_value = new Scanner(System.in);

        /*Регистрация количества записей в списке*/
        System.out.println("Введите количество человек: ");
        humans_array_value = enter_humans_array_value.nextInt();
        Human[] humans_database = new Human[humans_array_value];
        /*Ввод данных про людей, записи*/
        System.out.println("Введите данные о людях: ");
        for(int i = 0; i<humans_database.length; i++){
            String human_surname;
            Scanner enter_human_surname = new Scanner(System.in);
            String human_street;
            Scanner enter_human_street = new Scanner(System.in);
            int human_house;
            Scanner enter_human_house = new Scanner(System.in);
            /*Ввод полей для записей*/
            System.out.println("Ввод информации персоны №"+(i+1));
            System.out.println("Фамилия, улица, номер дома");
            human_surname = enter_human_surname.nextLine();
            human_street = enter_human_street.nextLine();
            human_house = enter_human_house.nextInt();
            humans_database[i] = new Human(human_surname,human_street,human_house);
        }
        System.out.println("База людей создана");
        System.out.println("====================");
        System.out.println("Cозданная база: ");

        for(int i = 0; i<humans_database.length; i++){
            System.out.println("==================");
            System.out.println("Запись номер - "+(i+1));
            System.out.println("Фамилия: "+humans_database[i].surname);
            System.out.println("Улица: "+humans_database[i].home_adress.street);
            System.out.println("Номер дома: "+humans_database[i].home_adress.house);
        }
        /*Прописанный функционал приложения*/
        int local_user_choose;
        Scanner enter_local_user_choose = new Scanner(System.in);
        System.out.println("Функции: ");
        System.out.println("1 - Поиск человека по фамилии");
        System.out.println("2 - Поиск человека по адресу");
        System.out.println("3 - Поиск людей живущих на одной улице");
        System.out.println("Введите: ");
        local_user_choose = enter_local_user_choose.nextInt();

        /*Поиск по фамилии*/
        if(local_user_choose==1){
            String surname_to_find;
            Scanner enter_surname_to_find = new Scanner(System.in);
            System.out.println("Введите фамилию: ");
            surname_to_find = enter_surname_to_find.nextLine();
            for(int i = 0; i<humans_database.length; i++){
                if(surname_to_find.equals(humans_database[i].surname)){
                    System.out.println("Фамилия найдена под записью: "+(i+1));
                }
            }
        }
        /*Поиск по адресу*/
        if(local_user_choose==2){
            String address_human_find;
            Scanner enter_address_human_find = new Scanner(System.in);
            int address_human_number;
            Scanner enter_address_human_number = new Scanner(System.in);
            System.out.println("Введите улицу: ");
            address_human_find = enter_address_human_find.nextLine();
            System.out.println("Введите номер дома: ");
            address_human_number = enter_address_human_number.nextInt();

            for(int i = 0; i<humans_database.length; i++){
                if(address_human_find.equals(humans_database[i].home_adress.street) && address_human_number == humans_database[i].home_adress.house){
                    System.out.println("Найден адрес в записи номер: "+(i+1));
                }
            }
        }
        /*Поиск людей живущих на одной улице*/
        if(local_user_choose==3){
            String find_street;
            Scanner enter_find_street = new Scanner(System.in);
            System.out.println("Введите улицу для нахождения: ");
            find_street = enter_find_street.nextLine();

            System.out.println("Список людей живущих по адресу: " + find_street);
            for(int i=0; i<humans_database.length; i++){
                if(humans_database[i].home_adress.street.equals(find_street)){
                    System.out.println((i+1)+")"+humans_database[i].surname);
                }
            }
        }

    }
    static void Task_Eight(){
        /* Аргументы для ввода */
        double x;
        Scanner x_num = new Scanner(System.in);
        double begin;
        Scanner begin_num = new Scanner(System.in);
        double end;
        Scanner end_num = new Scanner(System.in);
        double step;
        Scanner step_num = new Scanner(System.in);;

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
