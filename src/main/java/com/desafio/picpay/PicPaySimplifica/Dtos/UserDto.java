package com.desafio.picpay.PicPaySimplifica.Dtos;

import com.desafio.picpay.PicPaySimplifica.Entity.User.UserType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Pattern(regexp = "^[^0-9]*$", message = "O nome completo não deve conter números.")
    public String nomeCompleto;

    @NotBlank(message = "O e-mail é obrigatório.")
    @NotBlank
    public String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
    public String senha;

    @NotBlank(message = "O documento é obrigatório.")
    @Pattern(regexp = "^(\\d{11}|\\d{14})$", message = "O documento deve ser um CPF (11 dígitos) ou um CNPJ (14 dígitos).")
    public String documento;

    @NotNull(message = "O saldo é obrigatório.")
    @PositiveOrZero(message = "O saldo deve ser zero ou positivo.")
    public BigDecimal saldo;

    @NotNull(message = "O tipo é obrigatório.")
    public UserType tipo;
}