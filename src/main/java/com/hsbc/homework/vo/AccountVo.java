package com.hsbc.homework.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.hsbc.homework.entity.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  description:  Customer entity
 *  author: mark3
 *  Date: 2021-05-29
 */

@Data
@Builder
public class AccountVo {

    private String id;

    @NotNull(message = "开始日期[startDate]不能为空")
    @ApiModelProperty(value = "开始日期",example = " ",required=true)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;


    @NotNull(message = "余额[balance]不能为空")
    @ApiModelProperty(value = "余额",example = " ",required=true)
    private BigDecimal balance;


    @NotEmpty(message = "交易[transcations]不能为空")
    @ApiModelProperty(value = "交易",example = " ",required=true)
    private String transcations;


    @NotNull(message = "产品类型[productType]不能为空")
    @ApiModelProperty(value = "产品类型",example = " ",required=true)
    private int productType;

    @NotEmpty(message = "客户主键[customerId]不能为空")
    @ApiModelProperty(value = "客户主键主键",example = "")
    private String customerId;

    public AccountVo() {
    }

    public AccountVo(String id, Date startDate,  BigDecimal balance, String transcations, int productType, String customerId) {
        this.id = id;
        this.startDate = startDate;
        this.balance = balance;
        this.transcations = transcations;
        this.productType = productType;
        this.customerId = customerId;
    }

    /**
     * 将Vo转换成实体
     * @author mark3
     */
    public Account changeAccountVoToEntity (AccountVo accountVo) {
        Account account=new Account();
        BeanUtils.copyProperties(accountVo,account);
        return  account;
    }



}
