package com.coindesk.service;

import com.coindesk.user.User;
import com.coindesk.user.UsersRepository;

import java.util.List;

public class UsersService {
    private UsersRepository users;

    public UsersService(UsersRepository users) {
        this.users = users;
    }

    public void save(User user){
        users.save(user);
    }

    public void saveAlluser(List<User> userList){
        users.saveAll(userList);
    }

    public Iterable<User> findAll(){
        return users.findAll();
    }
}
