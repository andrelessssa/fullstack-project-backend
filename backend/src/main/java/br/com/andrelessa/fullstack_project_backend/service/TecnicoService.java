package br.com.andrelessa.fullstack_project_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrelessa.fullstack_project_backend.domain.Tecnico;
import br.com.andrelessa.fullstack_project_backend.repository.TecnicoRepository;
import br.com.andrelessa.fullstack_project_backend.service.exception.ObjectnotFoundException;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto Não Encontrado!"));

    }
}
