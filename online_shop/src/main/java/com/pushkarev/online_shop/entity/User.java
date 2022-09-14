package com.pushkarev.online_shop.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "online_shop.users")
public class User {
		
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private int enabled = 1;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "online_shop.authorities"
	, joinColumns = @JoinColumn(name = "username")
	, inverseJoinColumns = @JoinColumn(name = "authority"))
	private List<Role> roles = Arrays.asList(new Role("ROLE_USER"));
				
	public User() {

	}

	public User(String username, String password, int enabled, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", url=" + password + ", enabled=" + enabled + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = "{noop}" + password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
