package com.desafio.picpay.PicPaySimplifica.Entity.User;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "User")
@Table(name = "User")
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

}

