package com.smartHome.solution.service;

import com.smartHome.solution.exception.ResourceNotFoundException;
import com.smartHome.solution.model.User;
import com.smartHome.solution.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User checkIn(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setCheckedIn(true);
            return userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    public User checkOut(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setCheckedIn(false);
            return userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }
}
