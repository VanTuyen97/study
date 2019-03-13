/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vantuyen361
 */
public class Map_Lambda {
    public static Map<String, String> map = new HashMap();
    static{
        map.put("name", "Tuyen");
        map.put("age", "22");
        map.put("job", "Student");
        map.put("sex", "male");
    }
    
    public void loop_Lambda(){
        map.forEach((key, value)->{
            System.out.println("key: " + key + ", value: " + value);
        });
    }
    
}
