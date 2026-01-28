package com.levmin.nginxtest.headfirst;

public class Demo01 {

    public static void main(String[] args) {
        int a = 3;
        while (a > 0) {
            if (a > 2) {
                System.out.print("a");
            }
            if (a == 2) {
                System.out.print("b c");
            }
            a = a - 1;
            System.out.print("-");
            if (a == 1) {
                System.out.println("d");
                a = a - 1;
            }
        }


        int x = 0;
        int y = 0;
        while (x < 5) {
//            y = x - y;
//            y  = y + x;
//            y = y +2;
//            if (y > 4){
//                y = y - 1;
//            }
            x = x + 1;
            y = y + x;
            System.out.print(x + "" + y + " ");
            x = x + 1;
        }


    }
}
