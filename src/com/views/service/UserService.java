package com.views.service;

import com.views.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    public boolean addUser(User user);

    public boolean login(User user);

    public List getAllUser();

    public List<User> getUser(String email, String passwd);

    public User getUserByName(String name);

    public User getUserByEmail(String email);

    public User getUserById(int id);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
}
