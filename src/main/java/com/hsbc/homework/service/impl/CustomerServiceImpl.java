package com.hsbc.homework.service.impl;
import com.hsbc.homework.common.enums.HandelStatus;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.common.exception.NotFoundException;
import com.hsbc.homework.entity.Account;
import com.hsbc.homework.entity.Customer;
import com.hsbc.homework.respositoy.AccountResposity;
import com.hsbc.homework.respositoy.CustomerResposity;
import com.hsbc.homework.service.CustomerService;
import com.hsbc.homework.vo.CustomerVo;
import com.hsbc.homework.vo.CPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;
/**
 *  description:  Customer ServiceImp
 *  author: mark3
 *  Date: 2021-05-29
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerResposity customerResposity;

    @Autowired
    private AccountResposity accountResposity;

    @Override
    public CPage<CustomerVo> findAllCustomerByPage(CPage<CustomerVo> accountVoCPage) {
        Long totalSize= customerResposity.count();
        CPage<CustomerVo> CustomerVoCPage = new CPage(accountVoCPage, totalSize);
        if (totalSize == 0 || CustomerVoCPage.getStartPage() > CustomerVoCPage.getTotalPage(totalSize)) {
            return CustomerVoCPage;
        }
        List<CustomerVo> accountVos=findAllCustomer(accountVoCPage.getContent());
        CustomerVoCPage.setList(accountVos);
        return CustomerVoCPage;
    }

    @Override
    public List<CustomerVo> findAllCustomer(CustomerVo accountVo) {
        List<Customer> accounts =customerResposity.findAll();
        List<CustomerVo> accountVos=accounts.stream().map(x->{
            CustomerVo account=new CustomerVo();
            BeanUtils.copyProperties(x,account);
            account.setAccounts(accountResposity.findAccountByCustomerId(x.getId()));
            return  account;
        }).collect(Collectors.toList());
        return accountVos;
    }

    @Override
    public void saveCustomer(CustomerVo customerVo) {
        Customer account=  customerVo.chageCustomerVoToEntity(customerVo);
        customerResposity.save(account);
    }

    @Override
    public void updateCustomer(CustomerVo accountVo) throws GlobalException {
        String id=accountVo.getId();
        if(StringUtils.isEmpty(id)){
            throw new NotFoundException("id is not null", HandelStatus.NOT_FOUND);
        }
        checkCustomerIfExist(id);
        Customer account=  accountVo.chageCustomerVoToEntity(accountVo);
        customerResposity.save(account);
    }

    @Override
    public void deleteById(String id) throws GlobalException {
        checkCustomerIfExist(id);
        List<Account> accounts=accountResposity.findAccountByCustomerId(id);
        if(accounts!=null&&!accounts.isEmpty()){
            throw new NotFoundException("please delete the customer's account frist", HandelStatus.NOT_FOUND);
        }
        customerResposity.deleteById(id);
    }

    public  Customer checkCustomerIfExist(String id) throws GlobalException{
        Customer customer=customerResposity.findById(id).orElse(null);
        if(customer==null){
            throw new NotFoundException(String.format("%s:%s %s","this customer",id,"not exist"), HandelStatus.NOT_FOUND);
        }
        return customer;
    }
}
