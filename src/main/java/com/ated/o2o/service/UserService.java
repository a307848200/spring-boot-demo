package com.ated.o2o.service;

import com.ated.o2o.entity.User;
import com.ated.o2o.pojo.vo.UserUpdateVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zengwx
 */
public interface UserService {

    User findById(Long id);

    User findByAge(Integer age);

    Page<User> findAllUserByPage(int page, int size);

    User updateUser(UserUpdateVO vo);

    void deleteUser(Long id);
}
