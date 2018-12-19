
import org.junit.Test;
import start.Comparator_Lambda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vantuyen361
 */
public class Comparator_Lambda_Test {
    @Test 
    public void comparatorTest(){
        Comparator_Lambda comparator = new Comparator_Lambda();
        comparator.comparator();
    }
    
    @Test 
    public void comparatorLambdaTest(){
        Comparator_Lambda comparator = new Comparator_Lambda();
        comparator.comparatorLambda();
    }
}
