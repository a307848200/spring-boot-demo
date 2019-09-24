package com.ated.o2o.controller;

import com.ated.o2o.entity.User;
import com.ated.o2o.pojo.ResponseEntityDTO;
import com.ated.o2o.pojo.vo.BaseIdVO;
import com.ated.o2o.pojo.vo.UserUpdateVO;
import com.ated.o2o.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * user 控制层
 * @author zengwx
 */
@Slf4j
@RestController
@RequestMapping(UserController.REQUEST_PATH)
@Api(value = UserController.REQUEST_PATH, description = "user模块API")
public class UserController {

    @Autowired
    private UserService userService;

    final static String REQUEST_PATH = "/user/jpa";


    @ApiOperation(value = "根据ID获取用户信息", response = User.class)
    @GetMapping("/get/id/{id}")
    public ResponseEntity<String> getUserById(@ApiParam("用户ID") @PathVariable("id")Long id){
        log.info("request /user/get/id/{id}, parameter is "+id);
        User user = userService.findById(id);
        return ResponseEntityDTO.successful(user);
    }

    @ApiOperation(value = "根据年龄获取用户信息", response = User.class)
    @GetMapping("/get/age/{age}")
    public ResponseEntity<String> findByAge(@ApiParam("年龄") @PathVariable(value = "age")Integer age){
        return ResponseEntityDTO.successful(userService.findByAge(age));
    }

    @ApiOperation(value = "获取用户分页信息", response = User.class)
    @GetMapping("/get/all/{page}/{size}")
    public ResponseEntity<String> getAllUserByPage(@ApiParam("页码") @PathVariable("page")int page,
                                                   @ApiParam("条数") @PathVariable("size")int size){
        return ResponseEntityDTO.successful(userService.findAllUserByPage(page,size));
    }

    @ApiOperation(value = "保存或更新用户信息", response = User.class)
    @PostMapping("/update/")
    public ResponseEntity<String> addUser(@RequestBody UserUpdateVO vo){
        return ResponseEntityDTO.successful(userService.updateUser(vo));
    }

    @ApiOperation(value = "删除用户信息")
    @PostMapping("/delete/")
    public void getUserById(@RequestBody BaseIdVO vo){
        userService.deleteUser(vo.id);
    }


}
