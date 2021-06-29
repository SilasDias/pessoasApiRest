package com.projeto.pessoasApiRest.controller;

import com.projeto.pessoasApiRest.dto.request.PersonDTO;
import com.projeto.pessoasApiRest.dto.response.MessageResponseDTO;
import com.projeto.pessoasApiRest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) { //Passar o corpo da requisiçao criando o argo da propria entidade
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }
}
