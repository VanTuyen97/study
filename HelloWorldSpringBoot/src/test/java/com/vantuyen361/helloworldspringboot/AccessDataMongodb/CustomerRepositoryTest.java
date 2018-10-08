/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.helloworldspringboot.AccessDataMongodb;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author TuyenNV22
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired(required=true)
    CustomerRepository repository;
    
    @Test
    public void findAll() {
        List<Customer> customer = repository.findAll();
        System.out.println(customer);
    }
}
