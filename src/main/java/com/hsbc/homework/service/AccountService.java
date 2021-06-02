package com.hsbc.homework.service;
import com.hsbc.homework.common.exception.GlobalException;
import com.hsbc.homework.vo.AccountVo;
import com.hsbc.homework.vo.CPage;

import java.util.List;
/**
 *  description:  Account Service
 *  author: mark3
 *  Date: 2021-05-29
 */
public interface AccountService {

    CPage<AccountVo> findAllAccountByPage(CPage<AccountVo> accountVoCPage);

    List<AccountVo> findAccountVo(AccountVo accountVo);

    void saveAccount(AccountVo accountVo) throws GlobalException;

    void updateAccount(AccountVo accountVo) throws GlobalException;

    void deleteById(String id) throws GlobalException;

}
