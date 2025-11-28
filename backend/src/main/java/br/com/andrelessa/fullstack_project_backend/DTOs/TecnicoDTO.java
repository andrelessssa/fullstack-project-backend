package br.com.andrelessa.fullstack_project_backend.DTOs;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors; 

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.andrelessa.fullstack_project_backend.domain.Tecnico;

public record TecnicoDTO(
    Integer id,
    String nome,
    String cpf,
    String email,
    String senha, // <--- TEM QUE TER ESTA LINHA AQUI!
    Set<Integer> perfis,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCriacao
) {

    public TecnicoDTO(Tecnico obj) {
        this(
            obj.getId(),
            obj.getNome(),
            obj.getCpf(),
            obj.getEmail(),
            obj.getSenha(), // Aqui usamos getSenha() porque 'obj' é uma ENTIDADE (Classe)
            obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet()),
            obj.getDataCriacao()
        );
    }
}