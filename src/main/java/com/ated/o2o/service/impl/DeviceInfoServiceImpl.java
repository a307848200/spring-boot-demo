package com.ated.o2o.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.ated.o2o.common.OmsProperties;
import com.ated.o2o.pojo.bo.DeviceInfoBO;
import com.ated.o2o.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zengwx
 */
@Component
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {


    @Autowired
    private OmsProperties omsProperties;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<DeviceInfoBO> listDeviceInfoByCompId(Long compId) {
        String results = restTemplate.getForObject(omsProperties.getCoreUrl() + "deviceInfo/func/deviceList.do?compId="+compId, String.class);
        Assert.hasLength(results,"访问 deviceInfo/func/deviceList 返回空参");
        List<DeviceInfoBO> list = null;
        try {
            list = JSONArray.parseArray(results, DeviceInfoBO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.notEmpty(list,"DeviceInfoBO 转换失败");
        return list;
    }
}
