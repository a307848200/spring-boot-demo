package com.ated.o2o.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zengwx
 */
@Data
@ApiModel(value = "basePageVO", description = "分页搜索vo")
public class BasePageVO {

    @ApiModelProperty(value = "页码", name = "page")
    public int page = 0;

    @ApiModelProperty(value = "条数", name = "size")
    public int size = 10;

}
