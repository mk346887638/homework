package com.hsbc.homework.entity;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  description:  Customer entity
 *  author: mark3
 *  Date: 2021-05-29
 */
@Document(collection = "account")
@Data
@Builder
public class Account {

    @ApiModelProperty(value = "主键",example = "")
    @Id
    private String id;

    @ApiModelProperty(value = "开始日期",example = " ",required=true)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;


    @ApiModelProperty(value = "余额",example = " ",required=true)
    private BigDecimal balance;

    @ApiModelProperty(value = "交易",example = " ",required=true)
    private String transcations;

    @ApiModelProperty(value = "产品类型",example = " ",required=true)
    private int productType;

    @ApiModelProperty(value = "客户主键主键",example = "")
    private String customerId;

    public Account() {
    }

    public Account(String id, Date startDate, BigDecimal balance, String transcations, int productType, String customerId) {
        this.id = id;
        this.startDate = startDate;
        this.balance = balance;
        this.transcations = transcations;
        this.productType = productType;
        this.customerId = customerId;
    }



}
