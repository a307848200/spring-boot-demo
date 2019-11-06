package com.ated.o2o.dao;

import com.ated.o2o.entity.DeviceImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceImageRepository extends JpaRepository<DeviceImage,Long> {
    List<DeviceImage> findByDeviceInfoId(Long deviceInfoId);
}
