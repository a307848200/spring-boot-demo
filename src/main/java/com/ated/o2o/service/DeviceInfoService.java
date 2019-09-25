package com.ated.o2o.service;

import com.ated.o2o.pojo.bo.DeviceInfoBO;

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
}
