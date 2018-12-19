/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vantuyen361
 */
public class Person extends Common{

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name-" + name + "; age-" + age;
    }
    
    public static List<Person> build_Persons(){
        List<Person> persons = new ArrayList();
        persons.add(new Person("tuyen1", 22));
        persons.add(new Person("tuyen2", 21));
        persons.add(new Person("tuyen3", 20));
        persons.add(new Person("tuyen4", 23));
        persons.add(new Person("tuyen5", 24));
        persons.add(new Person("nam1", 22));
        persons.add(new Person("nam2", 21));
        persons.add(new Person("nam3", 20));
        persons.add(new Person("nam4", 23));
        persons.add(new Person("nam5", 24));
        return persons;
    }
    
    public void display(){
        log(this);
    }
}
