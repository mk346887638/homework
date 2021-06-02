package com.hsbc.homework;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.service.AccountService;
import com.hsbc.homework.vo.AccountVo;
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
class AccountTests {

    @Autowired
    AccountService accountService;


    @Test
    void testAccountList() {
        AccountVo accountVo = new AccountVo();
        List<AccountVo> accounts =accountService.findAccountVo(accountVo);
        Boolean flag=accounts!=null||!accounts.isEmpty();
        Assert.assertEquals(true,flag);

    }

    @Test
    void testAccountSave() throws GlobalException {
        AccountVo account =AccountVo.builder().
              id("1111").
              startDate(new Date()).
              balance(new BigDecimal(12.678989898).setScale(4, BigDecimal.ROUND_HALF_UP))
              .productType(1)
              .customerId("23232323").build();
        accountService.saveAccount(account);
    }

    @Test
    void testAccountUpdate() throws GlobalException {
        AccountVo account =AccountVo.builder().
                id("1111").
                startDate(new Date()).
                balance(new BigDecimal(12.098).setScale(4, BigDecimal.ROUND_HALF_UP))
                .productType(2)
                .customerId("23232323").build();
        accountService.updateAccount(account);
    }

    @Test
    void testAccountDelete() throws GlobalException {
        String id="1111";
        accountService.deleteById(id);
    }

}
