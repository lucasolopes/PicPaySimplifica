package com.desafio.picpay.PicPaySimplifica.Service;

import com.desafio.picpay.PicPaySimplifica.Dtos.UserDto;
import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import com.desafio.picpay.PicPaySimplifica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        User user = new User(userDto);
        this.saveUser(user);
        return user;
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
