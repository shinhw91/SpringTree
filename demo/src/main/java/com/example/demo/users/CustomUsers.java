package com.example.demo.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class CustomUsers implements UserDetails {
	
	private UsersVO usersVO;

	public CustomUsers(UsersVO usersVO) {
		this.usersVO = usersVO;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authlist = new ArrayList<>();
		authlist.add(new SimpleGrantedAuthority(usersVO.getGrade()));
		return authlist;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usersVO.getUserpw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usersVO.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
