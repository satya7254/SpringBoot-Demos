package com.satya.springboot.jdbi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public List<User> list(){
        System.out.println(userDao.list());
        return userDao.list();
    }

    @Transactional
    public Integer insert(){
        User test = new User();
        test.setName("username"+new Date().getTime());
        return userDao.insert(test);
    }

    @Transactional
	public String getUserById(int userId) {
		return userDao.getUserById(userId);
	}

    @Transactional
	public Integer getSum(int a, int b) {
		return userDao.getSum(a, b);
	}
}
