package com.example.spotify.controllers.services;

import java.util.ArrayList;

import com.example.spotify.controllers.repositories.UserRepository;
import com.example.spotify.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository uR;

    public void save(User user) { uR.save(user); }

    public ArrayList<User> getAll() { return (ArrayList<User>) uR.findAll(); }

    public User getByUserName(String username) { return uR.getByUsername(username); }

    public void delete(long id) { uR.delete(id); }
}