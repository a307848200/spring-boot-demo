package com.ated.o2o;

import com.ated.o2o.service.DeviceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class O2oApplicationTests {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Test
    public void listDeviceInfoByCompId() {
        log.info("list:{}",deviceInfoService.listDeviceInfoByCompId(335307L));
    }

}
