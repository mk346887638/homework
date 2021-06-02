package com.hsbc.homework.vo;
import com.hsbc.homework.entity.Account;
import com.hsbc.homework.entity.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 *  description:  Customer entity
 *  author: mark3
 *  Date: 2021-05-29
 */
@Data
@Builder
public class CustomerVo {

    @ApiModelProperty(value = "主键",example = "122149541117953 最大15个长度")
    @Id
    private String id;

    @NotEmpty(message = "名称[name]不能为空")
    @ApiModelProperty(value = "顾客名称",example = " ",required=true)
    private String name;

    @NotEmpty(message = "客户地址[address]不能为空")
    @ApiModelProperty(value = "地址",example = " ",required=true)
    private String address;

    @ApiModelProperty(value = "",example = " ",required=true)
    private List<Account> accounts;

    public CustomerVo() {
    }

    public CustomerVo(String id, String name, String address, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accounts = accounts;
    }

    /**
     * 将Vo转换成实体
     * @author mark3
     */
    public Customer chageCustomerVoToEntity (CustomerVo customerVo) {
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerVo,customer);
        return  customer;
    }


}
