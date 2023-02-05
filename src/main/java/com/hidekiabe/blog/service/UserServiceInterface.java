package com.hidekiabe.blog.service;

import com.hidekiabe.blog.model.User;

import java.util.List;

public interface UserServiceInterface {

    User save(User user);

    User update(User user);

    void delete(User user);

    List<User> findAll(User user);
}
