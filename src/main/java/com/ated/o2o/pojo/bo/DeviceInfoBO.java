package com.ated.o2o.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "deviceInfoBO")
public class DeviceInfoBO {

    @ApiModelProperty(name = "deviceId", value = "设备ID")
    private Long deviceId;

    @ApiModelProperty(name = "compId", value = "企业客户ID")
    private Long compId;

    @ApiModelProperty(name = "deviceCode", value = "设备号")
    private String deviceCode;

    @ApiModelProperty(name = "address", value = "设备地址")
    private String address;

    @ApiModelProperty(name = "deviceName", value = "设备名称")
    private String deviceName;

}
