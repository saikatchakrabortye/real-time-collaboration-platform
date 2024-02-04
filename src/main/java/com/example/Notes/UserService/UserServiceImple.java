package com.example.Notes.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
    public void deleteUser(User user)
    {
        userRepository.delete(user);
    }
    public void getAllUsers()
    {

    }
    public User getUserByUsername(String username)
    {
        //findByAll returns an optional object. If it finds the object only then it returns object
        return userRepository.findById(username).orElse(null);
    }
}
