package com.ated.o2o.pojo.vo;

import com.ated.o2o.entity.DeviceInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "saveDeviceInfoVO")
public class SaveDeviceInfoVO {
    @NotEmpty(message = "图片列表不能为空")
    @ApiModelProperty(name = "imageList", value = "图片列表", required = true)
    private List<String> imageList;

    @NotNull(message = "设备信息不能为空")
    @ApiModelProperty(name = "deviceInfo", value = "设备信息", required = true)
    private DeviceInfo deviceInfo;
}
