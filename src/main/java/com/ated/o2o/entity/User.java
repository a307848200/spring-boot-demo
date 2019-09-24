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
@Table(name="user_demo")
@ApiModel(value = "user", description = "用户表")
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "id", value = "主键")
    private Long id;

    @Column(name="user_age")
    @ApiModelProperty(name = "userAge", value = "年龄")
    public Integer userAge;

    @Column(name="user_name")
    @ApiModelProperty(name = "userName", value = "名称", required = true)
    public String userName;

}