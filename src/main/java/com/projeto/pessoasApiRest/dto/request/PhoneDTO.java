package com.projeto.pessoasApiRest.dto.request;

import com.projeto.pessoasApiRest.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING) //configurando o tipo de entrada
    private PhoneType type;

    @NotEmpty // Nao pode ser vazio
    @Size(min = 13, max = 14) //limitando o tamanho
    private String number;
}
