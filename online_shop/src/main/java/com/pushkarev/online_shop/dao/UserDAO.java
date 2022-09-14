package com.pushkarev.online_shop.dao;

import com.pushkarev.online_shop.entity.User;

public interface UserDAO {

	public void saveUser(User user);

	public User getUser(String username);
}
