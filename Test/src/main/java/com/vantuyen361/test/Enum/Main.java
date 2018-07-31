/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.test.Enum;

/**
 *
 * @author Tuyên
 */
public class Main {
    public enum Day {
        //Each constant has an argument used to construct an enum instance through the constructor
        MONDAY("thu hai"),
        TUESDAY("thu ba"),
        WEDNESDAY("thu bon"),
        THURSDAY("thu nam"),
        FRIDAY("thu sau"),
        SATURDAY("thu bay"),
        SUNDAY("chu nhat");

        private final String day;

        /**
         * Constructor used when create enum.
         * @param day
         */
        Day(String day) {//Must use constructor has a argument
            this.day = day;
        }

        public String getDay() {
            return day;
        }
    }

    public static void main(String[] args) {
        Day day1 = Day.FRIDAY;//Create a instance of enum
        
        for(Day day: Day.values()){//The value method return an array contain constant of Day enum
            System.out.printf("%s is \"%s\"\n", day, day.getDay());
        }
    }
}
