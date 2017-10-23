package com.sec.core.security;

import com.sec.example.entity.SysRole;
import com.sec.example.entity.SysUser;
import com.sec.example.service.SysRoleService;
import com.sec.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserService implements UserDetailsService {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleService sysRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserService.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<SysRole> userRoles = sysRoleService.findRolesByUsername(username);
		UserDetails userDetails = new UserDetails() {
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> auths = new ArrayList<>();
				List<SysRole> roles = userRoles;
				for (SysRole role : roles) {
					auths.add(new SimpleGrantedAuthority(role.getName()));
				}
				return auths;
			}

			@Override
			public String getPassword() {
				return user.getPassword();
			}

			@Override
			public String getUsername() {
				return user.getUsername();
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}
		};
		if (userDetails == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return userDetails;
	}

}
