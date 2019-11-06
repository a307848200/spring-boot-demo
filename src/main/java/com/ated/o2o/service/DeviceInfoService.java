package com.ated.o2o.service;

import com.ated.o2o.entity.DeviceInfo;
import com.ated.o2o.pojo.bo.DeviceInfoBO;
import com.ated.o2o.pojo.vo.SaveDeviceInfoVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author zengwx
 */
public interface DeviceInfoService {

    /**
     * 根据compId查询设备信息
     * @param compId
     * @return
     */
    public List<DeviceInfoBO> listDeviceInfoByCompId(Long compId);

    /**
     * 保存或更新设备信息
     * @param vo
     * @return
     */
    DeviceInfo saveDeviceInfo(SaveDeviceInfoVO vo);

    /**
     * 根据base64编码格式将图片存入七牛服务器
     * @param imageList
     * @return
     */
    ResponseEntity<String> DeviceImage(String imageList);
}
