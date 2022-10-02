package com.practices.userservices.repository;/*
 * author: Sadik Hassan
 * created: 6:51 pm, 02/10/2022
 */

import com.practices.userservices.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
  User findByUsername(String username);
}
