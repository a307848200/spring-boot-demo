package com.ated.o2o.controller;

import com.ated.o2o.entity.DeviceInfo;
import com.ated.o2o.pojo.ResponseEntityDTO;
import com.ated.o2o.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(UploadController.REQUEST_PATH)
@Api(value = UploadController.REQUEST_PATH, description = "upload模块API")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    final static String REQUEST_PATH = "/upload/jpa";

    @ApiOperation(value = "保存图片信息", response = DeviceInfo.class)
    @PostMapping("/save/")
    public ResponseEntity<String> saveOrUpdate(DeviceInfo model, @RequestParam(value = "file", required = false) MultipartFile[] file) throws IOException {
        return ResponseEntityDTO.successful(uploadService.saveOrUpdate(model,file));
    }

    @ApiOperation(value = "获取图片分页信息", response = DeviceInfo.class)
    @GetMapping("/get/all/{page}/{size}")
    public ResponseEntity<String> getAllUploadByPage(@ApiParam("页码") @PathVariable("page")int page,
                                                     @ApiParam("条数") @PathVariable("size")int size){
        return ResponseEntityDTO.successful(uploadService.findAllUploadByPage(page,size));
    }

    @ApiOperation(value = "根据设备ID获取信息", response = DeviceInfo.class)
    @PostMapping("/get/deviceId/{deviceId}")
    public ResponseEntity<String> findOneDeviceId(@PathVariable("deviceId")Long deviceId){
        return ResponseEntityDTO.successful(uploadService.findByDeviceId(deviceId));
    }

}
