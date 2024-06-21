package com.desafio.picpay.PicPaySimplifica.Controller;

import com.desafio.picpay.PicPaySimplifica.Dtos.UserDto;
import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import com.desafio.picpay.PicPaySimplifica.Repository.TransectionsRepository;
import com.desafio.picpay.PicPaySimplifica.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    private UserService usuarioService;

    @Autowired
    private TransectionsRepository transectionsRepository;

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody UserDto userDto) {
        User user = usuarioService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
