/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.helloworldspringboot.AccessDataMongodb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TuyenNV22
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository respository;

    @GetMapping("/getcustomer")
    public List<Customer> getCustomer(
            @RequestParam(value = "firstname", required = false) String firstName,
            @RequestParam(value = "lastname", required = false) String lastName) {

        if ((firstName == null) && (lastName == null)) {//both is null
            return null;
        }

        if (lastName == null) {//there is firstName
            return respository.findByFirstName(firstName);
        }

        if (firstName == null) {//there is lastName
            return respository.findByLastName(lastName);
        }

        return respository.findByFirstNameAndLastName(firstName, lastName);
    }
}
