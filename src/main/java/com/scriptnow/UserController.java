package com.scriptnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by piyushbedi on 16/04/2016.
 */

@RestController
public class UserController {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    public UserController() {}

    @RequestMapping(method = POST, value = "/user/{userName}")
    public User addUser(@PathVariable("userName") String userName) {
        return pharmacyRepository.addUser(userName);
    }

    @RequestMapping(method = GET, value = "/user/{userName}")
    public User getUser(@PathVariable("userName") String userName) {
        return pharmacyRepository.getUser(userName);
    }
}
