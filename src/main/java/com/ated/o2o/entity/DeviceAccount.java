package com.ated.o2o.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zengwx
 */
@Data
@Entity
@Builder
@Table(name="DMI_ACCOUNT")
@ApiModel(value = "account", description = "设备收款账号表")
public class DeviceAccount implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="DEVICE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "deviceId", value = "主键")
	private Long deviceId;

    @Column(name="ACCOUNT_TYPE")
    @ApiModelProperty(name = "accountType", value = "")
    private String accountType;

    @Column(name="ACCOUNT_ID")
    @ApiModelProperty(name = "accountId", value = "")
    private Long accountId;

    @Column(name="PAY_METHOD")
    @ApiModelProperty(name = "payMethod", value = "")
    private String payMethod;

    @Column(name="DG_PM_ID")
    @ApiModelProperty(name = "dgPmId", value = "")
    private Long dgPmId;

    @Column(name="IS_DEFAULT")
    @ApiModelProperty(name = "isDefault", value = "")
    private String isDefault;

    @Column(name="STATE")
    @ApiModelProperty(name = "state", value = "")
    private String state;
    
}
