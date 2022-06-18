package com.nazeem.scheduler.springboot.service;

import com.nazeem.scheduler.springboot.model.User;
import com.nazeem.scheduler.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //run every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void addUser(){
        Random r = new Random();
        Long num = r.nextLong(1,1000000);
        User user = User.builder()
                .username("user "+num)
                .build();

        userRepository.save(user);
        System.out.println("User data saved in db.."+user);




        System.out.println("Fetching every 5 seconds...");
    }


    //cron job run every 15 seconds
    //step/time in seconds *=year *=month *=hour *=min *=seconds
    @Scheduled(cron = "0/15 * * * * *")
    public void fetchUsers(){
        List<User> userList = userRepository.findAll();

        System.out.println("User count..."+userList.size());


        System.out.println("Fetching... every 15 seconds...");
    }
}
