package com.ated.o2o.service;

import com.ated.o2o.entity.User;
import com.ated.o2o.pojo.vo.UserUpdateVO;

import java.util.List;

/**
 * @author zengwx
 */
public interface UserService {

    User findById(Long id);

    User findByAge(Integer age);

    List<User> findAllUserByPage(int page, int size);

    User updateUser(UserUpdateVO vo);

    void deleteUser(Long id);
}
