package com.ApricotMarket.service;

import com.ApricotMarket.controller.UserForm;
import com.ApricotMarket.domain.User;
import com.ApricotMarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface UserService {
    User save(UserForm user);

}