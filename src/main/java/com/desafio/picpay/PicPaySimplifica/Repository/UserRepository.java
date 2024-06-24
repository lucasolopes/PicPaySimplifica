package com.desafio.picpay.PicPaySimplifica.Repository;

import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
}