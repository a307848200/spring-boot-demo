package com.ated.o2o.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@Entity
@Table(name="ot_device_info")
@ApiModel(value = "DEVICE_INFO", description = "设备信息")
@EntityListeners(AuditingEntityListener.class)
public class DeviceInfo implements Serializable {

    @Id
    @ApiModelProperty(name = "id", value = "主键")
    @Column(name = "ID", columnDefinition = "varchar(32) not null comment '主键'", updatable = false)
    private Long id;

    @ApiModelProperty(name="address",value = "设备地址")
    @Column(name = "ADDRESS", columnDefinition = "varchar(100) comment '设备地址'")
    public String address;

    @CreatedDate
    @ApiModelProperty(name = "createTime", value = "创建时间")
    @Column(name = "CREATE_TIME", columnDefinition = "datetime not null comment '创建时间'", updatable = false)
    private Date createTime;

    @LastModifiedDate
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @Column(name = "UPDATE_TIME", columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;

    @ApiModelProperty(name = "agentsId", value = "对应设备表ID", required = true)
    @Column(name = "DEVICE_ID", columnDefinition = "decimal(20) not null comment '对应设备信息的ID'", updatable = false)
    private Long deviceId;

}
