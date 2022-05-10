package com.example.spotify.controllers.repositories;

import java.util.ArrayList;

import com.example.spotify.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepository {

    public ArrayList<User> findAll() {
        String url = "http://localhost:8080/users";
        RestTemplate rt = new RestTemplate();
        ArrayList<User> User = new ArrayList<>();
        User = rt.getForObject(url, ArrayList.class);
        return User;
    }

    public User getByUsername(String username){
        String url = "http://localhost:8080/users/"+username;
        RestTemplate rt = new RestTemplate();
       User user;
        user = rt.getForObject(url, User.class);
        return user;
    }

    public void delete(long id) {
        String url = "http://localhost:8080/users/delete/" + id;
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
    }

    public void save(User es) {
        String url = "http://localhost:8080/users/save";
        RestTemplate rt = new RestTemplate();
        rt.postForObject(url, es, User.class);
    }
}