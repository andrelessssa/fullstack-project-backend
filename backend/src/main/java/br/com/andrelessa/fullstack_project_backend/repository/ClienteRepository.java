package br.com.andrelessa.fullstack_project_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrelessa.fullstack_project_backend.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
