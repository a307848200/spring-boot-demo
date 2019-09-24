package com.ated.o2o.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @author zengwx
 */
@Data
@Builder
public class ResponseEntityDTO implements Serializable {

    /**
     * 响应码
     */
    public int code;

    /**
     * 消息
     */
    public String msg;

    /**
     * 数据
     */
    private Object data;

    public static ResponseEntity<String> successful(Object data){
        ResponseEntityDTO responseEntityDTO = ResponseEntityDTO.builder()
                .code(ResponseCode.SUCCESS.getCode())
                .data(data)
                .msg(ResponseCode.SUCCESS.getMsg())
                .build();
        return ResponseEntity.ok(JSONObject.toJSONString(responseEntityDTO));
    }

    public static ResponseEntity<String> successful(Object data, String msg){
        ResponseEntityDTO responseEntityDTO = ResponseEntityDTO.builder()
                .code(ResponseCode.SUCCESS.getCode())
                .data(data)
                .msg(msg)
                .build();
        return ResponseEntity.ok(JSONObject.toJSONString(responseEntityDTO));
    }

    public static ResponseEntity<String> error(Object data){
        ResponseEntityDTO responseEntityDTO = ResponseEntityDTO.builder()
                .code(ResponseCode.ERROR.getCode())
                .data(data)
                .msg(ResponseCode.ERROR.getMsg())
                .build();
        return ResponseEntity.ok(JSONObject.toJSONString(responseEntityDTO));
    }

    public static ResponseEntity<String> error(Object data, String msg){
        ResponseEntityDTO responseEntityDTO = ResponseEntityDTO.builder()
                .code(ResponseCode.ERROR.getCode())
                .data(data)
                .msg(msg)
                .build();
        return ResponseEntity.ok(JSONObject.toJSONString(responseEntityDTO));
    }

    public static ResponseEntity<String> custom(ResponseCode responseCode, Object data){
        ResponseEntityDTO responseEntityDTO = ResponseEntityDTO.builder()
                .code(responseCode.getCode())
                .data(data)
                .msg(responseCode.getMsg())
                .build();
        return ResponseEntity.ok(JSONObject.toJSONString(responseEntityDTO));
    }

}
