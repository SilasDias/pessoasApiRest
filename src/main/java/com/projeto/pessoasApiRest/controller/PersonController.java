package com.projeto.pessoasApiRest.controller;

import com.projeto.pessoasApiRest.dto.response.MessageResponseDTO;
import com.projeto.pessoasApiRest.entity.Person;
import com.projeto.pessoasApiRest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping //criar um livro
    @ResponseStatus(HttpStatus.CREATED) //Retorna erro de construido
    public MessageResponseDTO createPerson(@RequestBody Person person) { //Passar o corpo da requisiçao criando o argo da propria entidade
        return personService.createPerson(person);
    }
}
