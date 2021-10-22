package com.company;
import java.util.Random;

public class Player {
    String player_name;
    int value_of_wins; //Количество побед
    int main_points; //Переменная для количества очков после каждого броска

    /*Конструктор для регистрации*/
    public Player(String player_name){
        this.player_name = player_name;
    }

    /*Метод для броска кубика*/
    void GameCubeThrow(){
        int min = 1;
        int max = 6;
        int diff = max - min;
        Random random = new Random();
        GameCube.after_throw_value = random.nextInt(diff + 1);
    }

    /*Вложенный класс игрового кубика*/
    static class GameCube {
        static int after_throw_value;
    }


}
