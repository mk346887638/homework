package com.hsbc.homework;

import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.service.AccountService;
import com.hsbc.homework.service.CustomerService;
import com.hsbc.homework.vo.AccountVo;
import com.hsbc.homework.vo.CustomerVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CustomerTests {

    @Autowired
    CustomerService customerService;


    @Test
    void testAccountList() {
        CustomerVo customer = new CustomerVo();
        List<CustomerVo> customers =customerService.findAllCustomer(customer);
        Boolean flag=customers!=null||!customers.isEmpty();
        Assert.assertEquals(true,flag);

    }

    @Test
    void testAccountSave() throws GlobalException {
        CustomerVo account =CustomerVo.builder().
                id("23232323").
                name("mark3").
                address("xi'an city")
                .build();
        customerService.saveCustomer(account);
    }

    @Test
    void testAccountUpdate() throws GlobalException {
        CustomerVo account =CustomerVo.builder().
                id("23232323").
                name("mark2").
                address("guangzhou city")
                .build();
        customerService.updateCustomer(account);
    }

    @Test
    void testAccountDelete() throws GlobalException {
        String id="23232323";
        customerService.deleteById(id);
    }

}
