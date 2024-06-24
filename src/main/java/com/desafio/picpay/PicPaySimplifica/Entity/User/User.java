package com.desafio.picpay.PicPaySimplifica.Entity.User;

import com.desafio.picpay.PicPaySimplifica.Dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Usuarios")
@Table(name = "Usuarios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String email;
    private String senha;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private UserType type;

    public User(UserDto userDto) {
        this.nomeCompleto = userDto.nomeCompleto;
        this.email = userDto.email;
        this.senha = userDto.senha;
        this.documento = userDto.documento;
        this.saldo = userDto.saldo;
        this.type = userDto.tipo;
    }

}