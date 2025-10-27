package br.com.andrelessa.fullstack_project_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrelessa.fullstack_project_backend.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
