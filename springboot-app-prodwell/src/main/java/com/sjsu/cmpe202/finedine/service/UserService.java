package com.sjsu.cmpe202.finedine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.finedine.entity.User;
import com.sjsu.cmpe202.finedine.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User checkAndCreateUser(User userData) {
        return userRepository.findByOid(userData.getOid())
            .orElseGet(() -> createNewUser(userData));
    }

    private User createNewUser(User userData) {
        User newUser = new User();
        newUser.setOid(userData.getOid());
        newUser.setGiven_name(userData.getGiven_name());
        newUser.setFamily_name(userData.getFamily_name());
        newUser.setJobTitle(userData.getJobTitle());
        newUser.setCountry(userData.getCountry());
        newUser.setCity(userData.getCity());
        System.out.println(newUser);
        return userRepository.save(newUser);
    }

}
