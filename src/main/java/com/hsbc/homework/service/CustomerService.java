package com.hsbc.homework.service;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.vo.CustomerVo;
import com.hsbc.homework.vo.CPage;
import java.util.List;
/**
 *  description:  Customer Service
 *  author: mark3
 *  Date: 2021-05-29
 */
public interface CustomerService {

    CPage<CustomerVo> findAllCustomerByPage(CPage<CustomerVo> accountVoCPage);

    List<CustomerVo> findAllCustomer(CustomerVo accountVo);

    void saveCustomer(CustomerVo accountVo);

    void updateCustomer(CustomerVo accountVo) throws GlobalException;

    void deleteById(String id) throws GlobalException;

}
