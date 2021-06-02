package com.hsbc.homework.controller;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.service.CustomerService;
import com.hsbc.homework.vo.CustomerVo;
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
@Api(description = "the customer crud",tags = "customer base info")
@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @ApiOperation(value="account of page interface")
    @PostMapping("/list")
    public CPage<CustomerVo> findFuelAmountRecordByPage(@RequestBody CPage<CustomerVo> accountVoCPage) {
        return customerService.findAllCustomerByPage(accountVoCPage);
    }

    @ApiOperation(value="find all account interface")
    @GetMapping()
    public List<CustomerVo> findAllFuelAmountRecord(@RequestBody CustomerVo accountVo) {
        return customerService.findAllCustomer(accountVo);
    }

    @ApiOperation(value="save account  interface")
    @PostMapping
    public void save(@Validated @RequestBody CustomerVo accountVo){
        customerService.saveCustomer(accountVo);
    }

    @ApiOperation(value="update account interface")
    @PatchMapping
    public void update(@RequestBody CustomerVo accountVo) throws GlobalException{
        customerService.updateCustomer(accountVo);
    }

    @ApiOperation(value="delete the account interface")
    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable String id)throws GlobalException {
        customerService.deleteById(id);
    }



}
