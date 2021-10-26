package com.mchaves.Suporte.a.Clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DTOCliente {

    @NotEmpty(message = "O campo NOME não pode estar vazio")
    private String nome;
    @NotEmpty(message = "O campo CPF não pode estar vazio")
    private String cpf;
}
