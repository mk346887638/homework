package com.hsbc.homework.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 *  description:  Customer entity
 *  author: mark3
 *  Date: 2021-05-29
 */
@Document(collection = "customer")
@Data
public class Customer {

    @ApiModelProperty(value = "主键",example = "122149541117953 最大15个长度")
    @Id
    private String id;

    @NotEmpty(message = "名称[name]不能为空")
    @ApiModelProperty(value = "顾客名称",example = " ",required=true)
    private String name;

    @NotEmpty(message = "客户地址[address]不能为空")
    @ApiModelProperty(value = "地址",example = " ",required=true)
    private String address;


}
