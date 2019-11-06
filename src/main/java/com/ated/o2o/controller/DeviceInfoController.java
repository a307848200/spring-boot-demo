package com.ated.o2o.controller;

import com.ated.o2o.entity.DeviceImage;
import com.ated.o2o.pojo.ResponseEntityDTO;
import com.ated.o2o.pojo.vo.SaveDeviceInfoVO;
import com.ated.o2o.service.DeviceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(DeviceInfoController.REQUEST_PATH)
@Api(value = DeviceInfoController.REQUEST_PATH, description = "upload模块API")
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    final static String REQUEST_PATH = "/deviceInfo/jpa";


    @ApiOperation(value = "保存或更新设备图片信息", response = DeviceImage.class)
    @PostMapping(value = "/save/saveDeviceInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> saveCampusSet(@RequestBody SaveDeviceInfoVO vo) {
        return ResponseEntityDTO.successful(deviceInfoService.saveDeviceInfo(vo));
    }

    @ApiOperation(value = "上传图片到七牛")
    @PostMapping(value = "/upload/campusSetImage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> campusSetImage(@ApiParam(name = "imageList", value = "base64值")
                                                 @RequestParam(required = false) String imageList) {
        return deviceInfoService.DeviceImage(imageList);
    }


//    @ApiOperation(value = "获取图片分页信息", response = DeviceImage.class)
//    @GetMapping("/get/all/{page}/{size}")
//    public ResponseEntity<String> getAllUploadByPage(@ApiParam("页码") @PathVariable("page")int page,
//                                                     @ApiParam("条数") @PathVariable("size")int size){
//        return ResponseEntityDTO.successful(uploadService.findAllUploadByPage(page,size));
//    }
//
//    @ApiOperation(value = "根据设备ID获取信息", response = DeviceImage.class)
//    @PostMapping("/get/deviceId/{deviceId}")
//    public ResponseEntity<String> findOneDeviceId(@PathVariable("deviceId")Long deviceId){
//        return ResponseEntityDTO.successful(uploadService.findByDeviceId(deviceId));
//    }

}
