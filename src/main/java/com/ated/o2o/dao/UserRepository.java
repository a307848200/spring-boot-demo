package com.ated.o2o.dao;

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
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * spring data jpa 会自动注入实现（根据方法命名规范）
     * @return
     */
    User findByUserAge(int age);


    @Modifying
    @Query("delete from User u where u.id = :id")
    void deleteUser(@Param("id")Long id);
}