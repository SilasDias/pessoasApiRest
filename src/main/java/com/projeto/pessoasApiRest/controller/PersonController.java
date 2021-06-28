package com.projeto.pessoasApiRest.controller;

import com.projeto.pessoasApiRest.dto.response.MessageResponseDTO;
import com.projeto.pessoasApiRest.entity.Person;
import com.projeto.pessoasApiRest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired // injeta impletaçao tipo repository
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping //criar um livro
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Create person with ID " + savedPerson.getId())
                .build();
    }
}
