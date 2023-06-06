package org.example;

public class Main {
    public static void main(String[] args) {

        //Поупражняться с математическими и логическими операторами
        int a = 100;
        int b = 200;


        System.out.println("a+b=" + (a + b)); // сложение
        System.out.println("b-a=" + (b - a)); // вычитание
        System.out.println("a*b=" + (a * b)); // умножение
        System.out.println("b/a=" + (b / a)); // деление
        System.out.println("a%b=" + (a % b)); // остаток от деления
        System.out.println("a++=" + (++a)); // инкрамент
        System.out.println("b--=" + (--b)); // декримент
        //Добиться переполнения при вычислениях, посмотреть результаты (вывести в консоль)
        byte c = 127;

        System.out.println((byte) (c + 1));
        //Попробовать вычисления комбинаций типов данных (int и double)
        int d = 5;
        double e = 4.4;
        System.out.println("int+double=" + (d + e)); // сложение
        System.out.println("int-double=" + (d - e)); // вычитание
        System.out.println("int*double=" + (d * e)); // умножение
        System.out.println("int/double=" + (d / e)); // деление
        //Конструкция if/else
        int f = 1000;
        int j = 2000;
        if (f<j) {
            System.out.println("Первое число меньше второго");
        }
        else {
            System.out.println("Второе число меньше первого");
        }
        //Конструкция switch/case
        int num = 777;
        switch(num){

            case 666:
                System.out.println("число равно 666");
                break;
            case 777:
                System.out.println("число равно 777");
                break;
            case 555:
                System.out.println("число равно 555");
                break;
            default:
                System.out.println("число не равно 555, 666, 777");
        }
    }
}