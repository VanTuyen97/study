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
import java.util.function.Function;

/**
 * Transform a T to a U
 * {@link java.util.function.Function} is function interface to be support by Java 8
 * @author vantuyen361
 */
public class Function_Lambda extends Common{
    private List<Person> persons = new ArrayList();
    
    public Function_Lambda(){
        this.log("\n=====Function_Lambda=====");
        this.persons = Person.build_Persons();
    }
    
    public void print_Person(Function<Person, String> func){
        for(Person person : this.persons){
            this.log(func.apply(person));
        }
    }
    
    
    /**
     * Using Lambda expression to create instance of {@link java.util.function.Function}.
     * Convert to json format and print a list of persons. 
     */
    public void function_Lambda(){
//        Function<Person, String> func =  new Function<Person, String>() {
//            @Override
//            public String apply(Person person) {
//                return "{'name': '" + person.name + "', 'age': '"+ person.age +"}";
//            }
//        };
//        or
//        Function<Person, String> func = (person) -> {return "{'name':'" + person.name + "', 'age':'"+ person.age +"'}";};
//        or
        Function<Person, String> func = (person) -> "{'name':'" + person.name + "', 'age':'"+ person.age +"'}";
        
        this.print_Person(func);
    }
}
