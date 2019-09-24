package com.ated.o2o.service;

import com.ated.o2o.entity.DeviceAccount;

public interface DeviceService {

    /**
     * 根据主键获取 DeviceAccount
     * @param id
     * @return
     */
    DeviceAccount getAccountById(Long id);
}
