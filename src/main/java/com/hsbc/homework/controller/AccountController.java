package com.hsbc.homework.controller;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.service.AccountService;
import com.hsbc.homework.vo.AccountVo;
import com.hsbc.homework.vo.CPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 *  description:  Account Controller
 *  author: mark3
 *  Date: 2021-05-29
 */
@Api(description = "the Account crud",tags = "account base info")
@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;


    @ApiOperation(value="account of page interface")
    @PostMapping("/list")
    public CPage<AccountVo> findFuelAmountRecordByPage(@RequestBody CPage<AccountVo> accountVoCPage) {
        return accountService.findAllAccountByPage(accountVoCPage);
    }

    @ApiOperation(value="find all account")
    @GetMapping
    public List<AccountVo> findAllFuelAmountRecord(@RequestBody AccountVo accountVo) {
        return accountService.findAccountVo(accountVo);
    }

    @ApiOperation(value="save account  interface")
    @PostMapping
    public void save(@Validated @RequestBody AccountVo accountVo) throws GlobalException{
        accountService.saveAccount(accountVo);
    }

    @ApiOperation(value="update account  interface")
    @PatchMapping
    public void update(@RequestBody AccountVo accountVo)throws Exception{
        accountService.updateAccount(accountVo);
    }

    @ApiOperation(value="delete the account interface")
    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable String id)throws GlobalException {
        accountService.deleteById(id);
    }



}
