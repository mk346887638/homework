package com.hsbc.homework.service.impl;
import com.hsbc.homework.common.enums.HandelStatus;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.common.exception.NotFoundException;
import com.hsbc.homework.entity.Account;
import com.hsbc.homework.entity.Customer;
import com.hsbc.homework.respositoy.AccountResposity;
import com.hsbc.homework.respositoy.CustomerResposity;
import com.hsbc.homework.service.AccountService;
import com.hsbc.homework.vo.AccountVo;
import com.hsbc.homework.vo.CPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;
/**
 *  description:  Account ServiceImp
 *  author: mark3
 *  Date: 2021-05-29
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountResposity accountResposity;

    @Autowired
    private CustomerResposity customerResposity;



    @Override
    public CPage<AccountVo> findAllAccountByPage(CPage<AccountVo> accountVoCPage) {
        Long totalSize= accountResposity.count();
        CPage<AccountVo> AccountVoCPage = new CPage(accountVoCPage, totalSize);
        if (totalSize == 0 || AccountVoCPage.getStartPage() > AccountVoCPage.getTotalPage(totalSize)) {
            return AccountVoCPage;
        }
        List<AccountVo> accountVos=findAccountVo(accountVoCPage.getContent());
        AccountVoCPage.setList(accountVos);
        return AccountVoCPage;
    }

    @Override
    public List<AccountVo> findAccountVo(AccountVo accountVo) {
        List<Account> accounts = accountResposity.findAll();
        List<AccountVo> accountVos= accounts.stream().map(x->{
            AccountVo account= new AccountVo();
            BeanUtils.copyProperties(x,account);
            return  account;
        }).collect(Collectors.toList());
        return accountVos;
    }

    @Override
    public void saveAccount(AccountVo accountVo) throws GlobalException{
        Customer customer = customerResposity.findById(accountVo.getCustomerId()).orElse(null);
        if(customer==null){
            throw new NotFoundException(String.format("%s:%s %s","this customerId",accountVo.getCustomerId(),"not exist"), HandelStatus.NOT_FOUND);
        }
        Account account=  accountVo.changeAccountVoToEntity(accountVo);
        accountResposity.save(account);
    }

    @Override
    public void updateAccount(AccountVo accountVo) throws GlobalException{
        String id=accountVo.getId();
        if(StringUtils.isEmpty(id)){
            throw new NotFoundException("id is not null", HandelStatus.NOT_FOUND);
        }
       Account account= checkAccountIfExist(id);
        if(account!=null){
            account =Account.builder()
                    .id(accountVo.getId())
                    .startDate(accountVo.getStartDate())
                    .productType(accountVo.getProductType())
                    .balance(accountVo.getBalance())
                    .customerId(accountVo.getCustomerId())
                    .transcations(accountVo.getTranscations())
                    .build();
        }

        accountResposity.save(account);
    }

    @Override
    public void deleteById(String id) throws GlobalException {
        checkAccountIfExist(id);
        accountResposity.deleteById(id);
    }

    public  Account checkAccountIfExist(String id) throws GlobalException{
        Account account=accountResposity.findById(id).orElse(null);
        if(account==null){
            throw new NotFoundException(String.format("%s:%s %s","this account",id,"not exist"), HandelStatus.NOT_FOUND);
        }
        return account;
    }
}
