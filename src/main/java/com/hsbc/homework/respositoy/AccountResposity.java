package com.hsbc.homework.respositoy;
import com.hsbc.homework.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *  description:  Account resposity
 *  author: mark3
 *  Date: 2021-05-29
 */
public interface AccountResposity extends MongoRepository<Account,String> {

   List<Account> findAccountByCustomerId(String customerId) ;


}
