package com.ated.o2o.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zengwx
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "userUpdateVO")
public class UserUpdateVO extends BaseIdVO{

    @ApiModelProperty(value = "密码", name = "password", required = true)
    public String password;

    @ApiModelProperty(value = "用户名", name = "userName", required = true)
    public String userName;

}
