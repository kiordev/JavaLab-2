package com.company;
import java.util.Random;

public class Player {
    String player_name;
    int value_of_wins;
    /*Поля класса для очков*/

    public Player(String player_name){
        this.player_name = player_name;
    }

    void CubeThrow(){

    }

    static class GameCube {
        int after_throw_value;
        int cube_general_result;
        int min = 1;
        int max = 6;
        int diff = max - min;
        Random random = new Random();
        //присвоение= random.nextInt(diff + 1);
    }



}
