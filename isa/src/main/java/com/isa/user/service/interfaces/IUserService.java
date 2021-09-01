package com.isa.user.service.interfaces;

import com.isa.user.domain.User;

public interface IUserService {
    User findByEmail(String email);
}
