package com.pushkarev.online_shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "online_shop.role")
public class Role {
	
	@Id
	@Column(name = "role_name")
    private String roleName;
        
    public Role() {
    	
    }
    
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + ", roleName=" + roleName + ", users=" + "]";
	}
    
}
