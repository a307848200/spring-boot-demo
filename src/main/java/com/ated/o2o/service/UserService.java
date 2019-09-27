package com.ated.o2o.service;

import com.ated.o2o.entity.User;
import com.ated.o2o.pojo.vo.UserUpdateVO;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author zengwx
 */
public interface UserService {

    User findById(Long id);

    Page<User> findAllUserByPage(int page, int size);

    User updateUser(UserUpdateVO vo);

    User findByUserNameAndPassword(String userName , String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    void deleteUser(Long id);
}
