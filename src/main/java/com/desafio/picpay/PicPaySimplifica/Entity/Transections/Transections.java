package com.desafio.picpay.PicPaySimplifica.Entity.Transections;

import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Transections")
@Table(name = "Transections")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User reciver;

    private BigDecimal amount;
}
