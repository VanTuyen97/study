
import global.Person;
import java.util.List;
import org.junit.Test;
import start.Collections_Lambda;

/**
 * @author vantuyen361
 */
public class Collections_Lambda_Test {
    @Test
    public void loop_Lambda_Test() {
        Collections_Lambda collections = new Collections_Lambda();
        collections.loop_Lambda();
    }
    
    @Test
    public void filter_Lambda_Test() {
        List<Person> persons;
        Collections_Lambda collections = new Collections_Lambda();
        persons = collections.filter_Lambda(22);
        
        //display person
        if(persons == null) return;
        persons.forEach(Person::display);
    }
    
    @Test
    public void sum_Age_Lambda_Test() {
        Collections_Lambda collections = new Collections_Lambda();
        collections.sum_Age_Lambda();
    }
    
    @Test
    public void average_Age_Lambda_Test() {
        Collections_Lambda collections = new Collections_Lambda();
        collections.average_Age_Lambda();
    }
    
    @Test
    public void count_Person_Lambda_Test() {
        Collections_Lambda collections = new Collections_Lambda();
        collections.count_person_Lambda();
    }
}
