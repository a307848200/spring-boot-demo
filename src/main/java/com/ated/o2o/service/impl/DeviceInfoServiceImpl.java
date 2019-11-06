package com.ated.o2o.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.ated.o2o.common.properties.OmsProperties;
import com.ated.o2o.common.util.QiNiuApiUtil;
import com.ated.o2o.dao.DeviceImageRepository;
import com.ated.o2o.dao.DeviceInfoRepository;
import com.ated.o2o.entity.DeviceImage;
import com.ated.o2o.entity.DeviceInfo;
import com.ated.o2o.pojo.ResponseEntityDTO;
import com.ated.o2o.pojo.bo.DeviceInfoBO;
import com.ated.o2o.pojo.vo.SaveDeviceInfoVO;
import com.ated.o2o.service.DeviceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author zengwx
 */
@Slf4j
@Component
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {


    @Autowired
    private OmsProperties omsProperties;

    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @Autowired
    private DeviceImageRepository deviceImageRepository;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public DeviceInfo saveDeviceInfo(SaveDeviceInfoVO vo) {

        DeviceInfo deviceInfo = vo.getDeviceInfo();
        DeviceInfo deviceInfoResult = deviceInfoRepository.save(deviceInfo);
        if (!vo.getImageList().isEmpty()) {
            DeviceImage deviceImage = null;
            List<DeviceImage> deviceImageList = new LinkedList<>();
            for (String imageUrl : vo.getImageList()) {
                deviceImage = DeviceImage.builder()
                        .device_info(deviceInfoResult)
                        .imageUrl(imageUrl)
                        .build();
                deviceImageList.add(deviceImage);
            }
            deviceImageRepository.save(deviceImageList);
        }
        return deviceInfo;
    }

    @Override
    public ResponseEntity<String> campusSetImage(String imageList) {
        log.info("==上传图片==");
        log.info("==接收到的数据==" + imageList);
        String dataPrix = "";
        String data = "";
        if (imageList == null || "".equals(imageList)) {
            return ResponseEntityDTO.successful("上传失败，上传图片数据为空", "401");
        } else {
            String[] d = imageList.split("base64,");
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                data = d[1];
            } else {
                return ResponseEntityDTO.successful("上传失败，数据不合法", "401");
            }
        }
        String suffix = "";
        if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
            suffix = ".png";
        } else {
            return ResponseEntityDTO.error("上传图片格式不合法");
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String tempFileName = uuid + suffix;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(data);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(tempFileName);
            out.write(b);
            out.flush();
            out.close();
            File createFile = new File(tempFileName);
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(createFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String rand = String.valueOf(System.currentTimeMillis());
            QiNiuApiUtil.uploadForStream(inputStream, rand);
            createFile.delete();
            return ResponseEntityDTO.successful(omsProperties.getQiNiuResourcesUrl() + rand);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntityDTO.error("上传图片失败");
        }
    }
}
