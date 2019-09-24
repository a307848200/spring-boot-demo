package com.ated.o2o.dao;

import com.ated.o2o.entity.DeviceAccount;
import com.ated.o2o.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zengwx
 */
@Repository
public interface DeviceAccountRepository extends JpaRepository<DeviceAccount, Long> {
}