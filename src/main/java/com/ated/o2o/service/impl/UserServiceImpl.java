package com.ated.o2o.service.impl;

import com.ated.o2o.common.util.Md5SaltTool;
import com.ated.o2o.dao.UserRepository;
import com.ated.o2o.entity.User;
import com.ated.o2o.pojo.vo.UserUpdateVO;
import com.ated.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zengwx
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findAllUserByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return userRepository.findAll(pageable);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public User updateUser(UserUpdateVO vo) {
        String encryptedPwd = Md5SaltTool.getStrMD5(vo.password);
        User user = User.builder()
                .userName(vo.userName)
                .password(encryptedPwd)
                .build();
        return userRepository.save(user);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String encryptedPwd = Md5SaltTool.getStrMD5(password);
        User user = userRepository.findByUserNameAndPassword(userName, encryptedPwd);
        return user;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

}
