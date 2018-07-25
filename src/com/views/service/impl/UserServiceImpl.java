package com.views.service.impl;

import com.views.dao.UserDao;
import com.views.entity.User;
import com.views.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


//注入服务
@Service("userService")
public class UserServiceImpl implements UserService {
    //自动注入userDao，也可以使用@Autowired
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean addUser(User user){
        this.userDao.add(user);
        return true;
    }

    @Override
    public boolean login(User user){
        return this.userDao.login(user);
    }

    @Override
    public List getAllUser() {
        return this.userDao.getUser();
    }

    @Override
    public List<User> getUser(String email, String passwd) {
        return this.userDao.getUser(email, passwd);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserById(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        this.userDao.update(user);
        return true;
    }


    @Override
    public boolean deleteUser(int id) {
        this.userDao.delete(id);
        return true;
    }
}
