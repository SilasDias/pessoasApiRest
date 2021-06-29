package com.projeto.pessoasApiRest.repository;

import com.projeto.pessoasApiRest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository faz todos gerenciador de conexao do banco de dados e faz o Crud basico do banco entitymanager
public interface PersonRepository  extends JpaRepository<Person, Long> {
}
