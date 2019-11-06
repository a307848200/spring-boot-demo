package com.ated.o2o.entity;

import io.swagger.annotations.Api;
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
import java.util.List;

@Data
@Builder
@Entity
@Table(name="ot_device_image")
@ApiModel(value = "DEVICE_IMAGE", description = "设备图片")
@EntityListeners(AuditingEntityListener.class)
public class DeviceImage implements Serializable {

    @Id
    @ApiModelProperty(name = "id", value = "主键")
    @Column(name = "ID", columnDefinition = "varchar(32) not null comment '主键'", updatable = false)
    private Long id;

    @CreatedDate
    @ApiModelProperty(name = "createTime", value = "创建时间")
    @Column(name = "CREATE_TIME", columnDefinition = "datetime not null comment '创建时间'", updatable = false)
    private Date createTime;

    @LastModifiedDate
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @Column(name = "UPDATE_TIME", columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;

    @ApiModelProperty(name = "imageUrl", value = "图片地址")
    @Column(name = "IMAGE_URL", columnDefinition = "varchar(1000) comment '图片地址'")
    private String imageUrl;

    @ApiModelProperty(name = "imageKey", value = "图片唯一值")
    @Column(name = "IMAGE_KEY", columnDefinition = "varchar(100) comment '图片唯一值'")
    private String imageKey;

    @ManyToOne(targetEntity = DeviceInfo.class)
    @ApiModelProperty(name="device_info",value = "设备信息")
    @JoinColumn(name = "DEVICE_INFO_ID", nullable = false, columnDefinition = "varchar(32) not null comment '设备信息ID'", updatable = false)
    public DeviceInfo device_info;
}
