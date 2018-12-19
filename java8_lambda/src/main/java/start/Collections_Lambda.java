/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import global.Common;
import global.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lambda manipulate with Collections
 * @author vantuyen361
 */
public class Collections_Lambda extends Common {

    private List<Person> persons = new ArrayList<Person>();

    public Collections_Lambda() {
        this.persons = Person.build_Persons();
    }

    /**
     * Create loop with lambda expression
     */
    public void loop_Lambda() {
        log("\n=====Collections Loop_Lambda=====");
//        this.persons.forEach(person -> person.display());
//        or
        this.persons.forEach(Person::display);
    }

    /**
     * Filter collection person use Lambda
     *
     * @param age
     * @return
     */
    public List<Person> filter_Lambda(int age) {
        log("\n=====Collections Filter_Lambda=====");
        List<Person> filter;
        filter = this.persons
                .stream()//take a collection as input an return a java.util.stream.Stream interface as output 
                .filter(person -> person.age == age)//filter
                .collect(Collectors.toList());//convert to list
//                .collect(Collectors.toSet());//convert to set
//                .collect(Collectors.toMap((Person person)-> person.toString(), (Person p) -> p));//convert to Map
        return filter;
    }

    /**
     * Calculator sum age of all person of list
     */
    public void sum_Age_Lambda() {
        log("\n=====Collections Sum_Age_Lambda=====");
        long sum = this.persons
                .stream()
                .mapToLong(p -> p.age)
                .sum();
        log(sum);
    }

    /**
     * Calculator average age of all person of list
     */
    public void average_Age_Lambda() {
        log("\n=====Collections Average_Age_Lambda=====");
        double average = this.persons
                .stream()
                .mapToLong(p -> p.age)//return long stream consisting of the result is age of person
                .average()//Calculator average
                .getAsDouble();//return double result
        log(average);
    }

    /**
     * Count number of person of list
     */
    public void count_person_Lambda() {
        log("\n=====Collections Count_Person_Lambda=====");
        long count = this.persons
                .stream()
                .count();
        log(count);
    }
}
