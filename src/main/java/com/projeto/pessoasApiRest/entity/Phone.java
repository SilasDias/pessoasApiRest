package com.projeto.pessoasApiRest.entity;

import com.projeto.pessoasApiRest.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // Declara a classe como uma entidade
@Data // Getters e Setters
@Builder // Construçao de objetos
@AllArgsConstructor // Construtores
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Delega que o banco de dados que vai gerar o id
    private Long id;

    @Enumerated(EnumType.STRING)// Estamos declarando que e um enum do tipo String
    @Column(nullable = false) // Força o banco de dados criar a coluna notNull
    private PhoneType type;

    @Column(nullable = false) // Força o banco de dados criar a coluna notNull
    private String number;
}
