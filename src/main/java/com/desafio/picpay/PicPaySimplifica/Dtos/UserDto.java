package com.desafio.picpay.PicPaySimplifica.Dtos;

import java.math.BigDecimal;

import com.desafio.picpay.PicPaySimplifica.Entity.User.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public String nomeCompleto;

    public String email;

    public String senha;

    public String documento;

    public BigDecimal saldo;

    public UserType tipo;
}
