package com.isa.user.service.interfaces;

import com.isa.user.domain.Authority;

public interface IAuthorityService {
    Authority findByName(String name);
}
