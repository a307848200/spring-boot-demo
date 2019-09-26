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
@Table(name="ot_work")
@ApiModel(value = "work", description = "工作表")
@EntityListeners(AuditingEntityListener.class)
public class Upload implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "id", value = "主键")
    public Long id;

    @CreatedDate
    @ApiModelProperty(name = "createTime", value = "创建时间")
    @Column(name="create_time")
    public Date createTime;

    @LastModifiedDate
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @Column(name="update_time")
    public Date updateTime;

    @Column(name="image")
    @ApiModelProperty(name="image",value = "图片")
    public String image;

    @Column(name="address")
    @ApiModelProperty(name="address",value = "地址")
    public String address;

    @Column(name="status")
    @ApiModelProperty(name="status",value = "状态")
    public String status;
}
