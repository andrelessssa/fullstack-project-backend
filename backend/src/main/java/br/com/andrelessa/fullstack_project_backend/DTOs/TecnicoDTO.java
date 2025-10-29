package br.com.andrelessa.fullstack_project_backend.DTOs;

// Importe tudo que o record precisa!
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors; 
import com.fasterxml.jackson.annotation.JsonFormat;

// Importe a entidade que vamos usar
import br.com.andrelessa.fullstack_project_backend.domain.Tecnico;

// 1. O CABEÇALHO DO RECORD (com os 6 campos)
public record TecnicoDTO(
    Integer id,
    String nome,
    String cpf,
    String email,
    Set<Integer> perfis, // <-- Este campo estava faltando no seu cabeçalho
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCriacao
) {

    // 2. O CONSTRUTOR DE CONVENIÊNCIA (com os 6 campos)
    public TecnicoDTO(Tecnico obj) {
        this( // "this()" chama o construtor principal (o de cima)
            obj.getId(),
            obj.getNome(),
            obj.getCpf(),
            obj.getEmail(),
            // Convertemos o Set<Perfil> (do obj) para o Set<Integer> (do DTO)
            obj.getPerfis().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet()),
            obj.getDataCriacao()
        );
    }
}