package com.example.demo.repository;


import com.example.demo.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

    Optional<UserInfo> findByEmail(String email);
    Optional<UserInfo> findByPassword(String password);
}
