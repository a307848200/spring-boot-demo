package com.ated.o2o.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zengwx
 */
@Data
@ApiModel(value = "baseIdVO")
public class BaseIdVO {
    @ApiModelProperty(value = "主键", name = "id")
    public Long id;
}
