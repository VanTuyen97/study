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
import java.util.function.Predicate;

/**
 * A property of the object passed as argument
 * {@link java.util.function.Predicate} is function interface to be support by Java 8
 * @author vantuyen361
 */
public class Predicate_Lambda extends Common{
    
    private List<Person> persons = new ArrayList<Person>();
    
    public Predicate_Lambda(){
        this.log("\n=====Predicate_Lambda=====");
        this.persons = Person.build_Persons();
    }
    
    public void filterPerson(Predicate <Person> pre){
        for(Person person: this.persons){
            if(pre.test(person)){
                this.log(person);
            }
        }
    }
    
    /**
     * use Lambda expression to create {@link java.util.function.Predicate} instance.
     */
    public void predicate_Lambda(){
        Predicate<Person> pre = person -> {return person.age > 22;};
//        or
//        Predicate<Person> pre = person -> person.age > 23;
//        or
//        Predicate<Person> pre = new Predicate<Person>(){
//            @Override
//            public boolean test(Person person) {
//                return person.age > 23;
//            }
//            
//        };
        this.filterPerson(pre);
    }
}
