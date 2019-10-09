package com.ated.o2o.service.impl;

import com.ated.o2o.dao.UploadRepository;
import com.ated.o2o.entity.DeviceInfo;
import com.ated.o2o.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.util.UUID;

@Service
public class UploadServiceImpl<main> implements UploadService {

    @Autowired
    private UploadRepository uploadRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public DeviceInfo saveOrUpdate(DeviceInfo model, MultipartFile[] file) throws IOException {



        return null;
    }

    @Override
    public Page<DeviceInfo> findAllUploadByPage(int page, int size) {
        Pageable pageable = new PageRequest(page,size);
        Page<DeviceInfo> uploads = uploadRepository.findAll(pageable);
        return uploads;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void delete(Long id) {
        uploadRepository.delete(id);
    }

    @Override
    public DeviceInfo findByDeviceId(Long deviceId) {
        return uploadRepository.findOne(deviceId);
    }

}
