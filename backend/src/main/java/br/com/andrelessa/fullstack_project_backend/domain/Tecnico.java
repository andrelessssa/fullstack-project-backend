package br.com.andrelessa.fullstack_project_backend.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.andrelessa.fullstack_project_backend.DTOs.TecnicoDTO;
import br.com.andrelessa.fullstack_project_backend.enums.Perfil;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("TECNICO")
public class Tecnico extends Pessoa {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy="tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    // --- O CONSTRUTOR QUE ESTAVA DANDO ERRO ---
    public Tecnico(TecnicoDTO obj) {
        super();
        this.id = obj.id();
        this.nome = obj.nome();
        this.cpf = obj.cpf();
        this.email = obj.email();
        
        // ATENÇÃO AQUI:
        this.senha = obj.senha(); // <-- É assim que se acessa dados de um Record!
        
        Set<Integer> perfisDoDTO = (obj.perfis() != null) ? obj.perfis() : new HashSet<>();
        
        this.perfis = perfisDoDTO.stream().map(x -> x).collect(Collectors.toSet());
        
        this.dataCriacao = (obj.dataCriacao() != null) ? obj.dataCriacao() : LocalDate.now();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}