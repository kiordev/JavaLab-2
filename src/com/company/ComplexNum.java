package com.company;

public class ComplexNum {
    int x;
    int i;
    int y;
    int z;

    public ComplexNum(int x,int i,int y){ //Конструктор комплексного числа
        this.x = x;
        this.i = i;
        this.y = y;
        z=x+(i*y);
    }

    void show_complex_num(){ //Функция для вывода комплексного числа
        System.out.println(z+"="+x+"+"+i+"x"+y);
    }

    void show_z(){
        System.out.println(z);
    }
}
