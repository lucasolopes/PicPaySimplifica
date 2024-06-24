package com.desafio.picpay.PicPaySimplifica.Service;

import com.desafio.picpay.PicPaySimplifica.Dtos.UserDto;
import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import com.desafio.picpay.PicPaySimplifica.Entity.User.UserType;
import com.desafio.picpay.PicPaySimplifica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    public User findById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("User nao encontrado"));
    }

    public void validatedTransection(User sender, BigDecimal amount) throws Exception {
        if (sender.getType() == UserType.Logista) {
            throw new Exception("Usuario é do tipo Logista. Nao esta autorizado a realizar tranzacao");
        }
        if (sender.getSaldo().compareTo(amount) < 0) {
            throw new Exception("saldo insuficiente");
        }
    }
}