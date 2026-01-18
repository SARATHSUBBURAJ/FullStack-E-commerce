package com.fullProject.demo.jwt.dao;

import com.fullProject.demo.jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,String> {
}
