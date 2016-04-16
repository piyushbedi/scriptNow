package com.scriptnow;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PharmacyRepository {
    private Map<String, User> users;

    public PharmacyRepository() {
        this.users = new HashMap<String, User>();
    }

    public User addUser(String userName) {
        User newUser = new User(userName);
        users.put(userName, newUser);
        return newUser;
    }

    public User getUser(String userName) {
        return users.get(userName);
    }
}
