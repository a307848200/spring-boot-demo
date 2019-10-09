package com.ated.o2o.service;

import com.ated.o2o.entity.DeviceInfo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {

    DeviceInfo saveOrUpdate(DeviceInfo model, MultipartFile[] file) throws IOException;

    Page<DeviceInfo>findAllUploadByPage(int page, int size);

    void delete(Long id);

    DeviceInfo findByDeviceId(Long deviceId);
}
