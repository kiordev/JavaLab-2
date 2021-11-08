package com.company;

public class Calculate {
    double x;
    double begin;
    double end;
    double step;

    public Calculate(double x,double begin, double end,double step){
        this.x = x;
        this.begin = begin;
        this.end = end;
        this.step = step;
    }

    void function_one(){ //Первая предложенная функция и её алгоритм
        double x_result = 0;
        System.out.println("Ответы: ");
        double i = begin;
        while(i<end){
            x_result = Math.cos(x);
            System.out.println("Точка: "+i+"="+x_result);
            i+=step;
            x+=step;
        }
    }

    void function_two(){ //Вторая предложенная функция и её алгоритм
        double x_result = 0;
        System.out.println("Ответы: ");
        double i = begin;
        while(i<end){
            x_result = Math.pow((1/3),x);
            System.out.println("Точка: "+i+"="+x_result);
            i+=step;
            x+=step;
        }
    }

}
