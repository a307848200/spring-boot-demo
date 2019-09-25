package com.ated.o2o.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zengwx
 */
@Data
@Builder
@Entity
@Table(name="ot_user")
@ApiModel(value = "user", description = "用户表")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

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

    @Column(name="user_name")
    @ApiModelProperty(name = "userName", value = "用户名", required = true)
    public String userName;

    @Column(name="password")
    @ApiModelProperty(name = "password", value = "密码", required = true)
    public String password;

}