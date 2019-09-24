package com.ated.o2o.service.impl;

import com.ated.o2o.dao.DeviceAccountRepository;
import com.ated.o2o.entity.DeviceAccount;
import com.ated.o2o.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengwx
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceAccountRepository deviceAccountRepository;

    @Override
    public DeviceAccount getAccountById(Long id) {

        return null;
    }
}
