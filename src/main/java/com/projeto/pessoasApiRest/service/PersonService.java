package com.projeto.pessoasApiRest.service;

import com.projeto.pessoasApiRest.dto.response.MessageResponseDTO;
import com.projeto.pessoasApiRest.entity.Person;
import com.projeto.pessoasApiRest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service // Gerenciar a classe resposavel pela regras de negocio
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){ //Passar o corpo da requisiçao criando o argo da propria entidade
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder() //Encapsula os dados de entrada evitar construir atraves do construtor
                .message("Create person with ID " + savedPerson.getId())
                .build();
    }
}
