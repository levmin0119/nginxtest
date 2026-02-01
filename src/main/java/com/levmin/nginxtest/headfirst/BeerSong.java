package com.levmin.nginxtest.headfirst;

public class BeerSong {

    public static void main(String[] args) {
        int num = 99;
        String word = "bottles";
        while (num > 0){

            if (num == 1){
                word = "bottle";
            }

            System.out.println(num + " "+word + " of beer on the wall");
            System.out.println(num + " "+ word + " of beer");
            System.out.println("Take one down");
            System.out.println("Pass it around");
            num --;

             if (num >0) {
                 System.out.println(num + " " + word + " of beer");
             } else {
                 System.out.println("No more bottles of beer on the wall");
             }
        }
        String [] pets = {"Fido","Zeus","Bin"};

        System.out.println(pets.length);

    }


}
