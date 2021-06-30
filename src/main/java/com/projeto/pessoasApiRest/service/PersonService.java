package com.projeto.pessoasApiRest.service;

import com.projeto.pessoasApiRest.dto.request.PersonDTO;
import com.projeto.pessoasApiRest.dto.response.MessageResponseDTO;
import com.projeto.pessoasApiRest.entity.Person;
import com.projeto.pessoasApiRest.exception.PersonNotFoundException;
import com.projeto.pessoasApiRest.mapper.PersonMapper;
import com.projeto.pessoasApiRest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Gerenciar a classe resposavel pela regras de negocio
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){ //Passar o corpo da requisiçao criando o argo da propria entidade
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder() //Encapsula os dados de entrada evitar construir atraves do construtor
                .message("Create person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
       Person person = personRepository.findById(id)
               .orElseThrow(() -> new PersonNotFoundException(id)); // Caso nao ache a pessoa e lancado uma excessao
//        Optional<Person> optionalPerson = personRepository.findById(id); //Optional evita verificaçoes Nulas
        return personMapper.toDTO(person);
    }
}