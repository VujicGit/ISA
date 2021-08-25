package com.isa.user.service.implementation;

import com.isa.user.domain.User;
import com.isa.user.repository.UserRepository;
import com.isa.user.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
