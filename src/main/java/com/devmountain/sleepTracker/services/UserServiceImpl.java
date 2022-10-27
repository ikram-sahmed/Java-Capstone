package com.devmountain.sleepTracker.services;

import com.devmountain.sleepTracker.dtos.UserDto;
import com.devmountain.sleepTracker.entities.User;
import com.devmountain.sleepTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
@Override
@Transactional
    public List<String> addUser(UserDto userDto){
    List<String> response = new ArrayList<>();
    User user = new User(userDto);
    userRepository.saveAndFlush(user);
    response.add("http://localhost:8080/home.html");
    return response;
    }
    @Override
    public List<String> userLogin(UserDto userDto){
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());

        if (userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("http://localhost:8080/steps.html");
                response.add(String.valueOf(userOptional.get().getId()));
            }else{
                response.add("Username or password is invalid");
            }
        }else{
            response.add("Username of password is invalid");
        }
        return response;
    }
}
