package com.example.spotify.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class User {
    
    private long Id;
    private String username;
    private String password;

    private Set<Role> role;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User (Long id, String username, String password){
        this.Id = id;
        this.username = username;
        this.password = password;
    }
}
