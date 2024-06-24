package com.desafio.picpay.PicPaySimplifica.Dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransectionsDto {

    @NotNull(message = "O ID do remetente não pode ser nulo")
    @Positive
    private Long senderId;

    @NotNull(message = "O ID do receptor não pode ser nulo")
    @Positive
    private Long receiverId;

    @NotNull(message = "O saldo é obrigatório.")
    @PositiveOrZero(message = "O saldo deve ser zero ou positivo.")
    private BigDecimal value;
}