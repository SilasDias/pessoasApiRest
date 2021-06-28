package com.projeto.pessoasApiRest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // Declara a classe como uma entidade
@Data // Getters e Setters
@Builder // Construçao dos Objetos
@AllArgsConstructor //Construtores
@NoArgsConstructor //Construtores
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Delega que o banco de dados que vai gerar o id indentando
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // Unique true vai permitir cadastrar cpfs unicos
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // Cascade forma de inserçao dos dados
    @Column(nullable = false)
    private List<Phone> phones;
}