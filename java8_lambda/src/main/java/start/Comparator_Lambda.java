/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import global.Common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vantuyen361
 */
public class Comparator_Lambda extends Common{

    public List<Integer> ints = new ArrayList<Integer>();

    public Comparator_Lambda() {
        this.ints.add(7);
        this.ints.add(6);
        this.ints.add(5);
        this.ints.add(4);
        this.ints.add(3);
        this.ints.add(2);
        this.ints.add(1);
        this.ints.add(0);
    }

    public void comparator() {
        this.log("\n=====Comparator=====");

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Objects.requireNonNull(o1);
                Objects.requireNonNull(o2);
                Integer number1 = (Integer) o1;
                Integer number2 = (Integer) o2;

                if (number1 > number2) {
                    return 1;
                }
                if (number1 == number2) {
                    return 0;
                }

                return -1;
            }
        };

        Collections.sort(this.ints, comparator);

        for (Integer index : this.ints) {
            this.log(index);
        }
    }

    /**
     * Create instance {@link java.util.Comparator} by use Lambda
     */
    public void comparatorLambda() {
        this.log("\n=====Comparator Lambda=====");

        Comparator comparator = (Object number1, Object number2) -> {
            Objects.requireNonNull(number1);
            Objects.requireNonNull(number2);
            return (Integer) number1 - (Integer) number2;
        };

        Collections.sort(this.ints, comparator);
        for (Integer index : this.ints) {
            this.log(index);
        }
    }
}
