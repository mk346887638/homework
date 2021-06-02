package com.hsbc.homework.respositoy;
import com.hsbc.homework.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *  description:  Account resposity
 *  author: mark3
 *  Date: 2021-05-29
 */
public interface CustomerResposity extends MongoRepository<Customer,String> {


}
