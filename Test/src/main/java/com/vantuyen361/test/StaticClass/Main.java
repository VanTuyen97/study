/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.test.StaticClass;

/**
 *
 * @author Tuyên
 */
public class Main {
    private static String propertyStatic = "property static in Main class (outer static class)"; 
    
    /**
     * this is a nested class.
     */

    public static class StaticClass{
        /**
         * is a property non-static
         */
        private String string;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
        /**
         * Method used to access static property in outer class
         * @return 
         */
        public String getPropertyStatic(){
            return propertyStatic;
        }
    }
    
    public static void main(String[]args){
        Main.StaticClass staticClass = new Main.StaticClass();
        staticClass.setString("property non-static in StaticClass class");//use non-static method in static method
        System.out.println(staticClass.getString());
        System.out.println(staticClass.getPropertyStatic());//access property static in outer class
    }
}
