package com.desafio.picpay.PicPaySimplifica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.picpay.PicPaySimplifica.Entity.User.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
