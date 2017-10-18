package com.sec.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.example.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByUsername(String username);
}
