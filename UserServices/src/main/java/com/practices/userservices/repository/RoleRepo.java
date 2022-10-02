package com.practices.userservices.repository;
/*
 * author: Sadik Hassan
 * created: 6:53 pm, 02/10/2022
 */

import com.practices.userservices.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
 Role findByName(String name);
}
