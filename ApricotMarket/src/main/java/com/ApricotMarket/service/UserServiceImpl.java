package com.ApricotMarket.service;

import com.ApricotMarket.controller.UserForm;
import com.ApricotMarket.domain.Role1;
import com.ApricotMarket.domain.User;
import com.ApricotMarket.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;    //비밀번호 암호화

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save(UserForm user) {
        /**
         * 여기서 그냥 저장하면 안 될것이다.
         * 그냥 저장하다면 사용자 이름과 비밀번호만 저장하는 꼴..
         */

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        String email = user.getEmail();

        // 로그인 중복
        if (userRepository.existsUserByEmail(email) == false) {
            User newUser = User.builder()
                    //.email(user.getEmail())
                    .password(user.getPassword())
                    .username(user.getEmail())
                    .enabled(true)
                    .role1(Role1.ROLE_USER)
                    .build();
            return userRepository.save(newUser);
        }

        return null;
    }
}