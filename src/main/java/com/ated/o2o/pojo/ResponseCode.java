package com.ated.o2o.pojo;

import lombok.Getter;

/**
 * @author zengwx
 */
@Getter
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(0,"成功"),
    /**
     * 失败
     */
    ERROR(1,"失败"),
    /**
     * 需要登录
     */
    NEED_LOGIN(1001,"需要登录");

    /**
     * 响应码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}