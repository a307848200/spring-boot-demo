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

    @ApiModelProperty(value = "年龄", name = "userAge", required = true)
    public Integer userAge;

    @ApiModelProperty(value = "名称", name = "userName", required = true)
    public String userName;

}
