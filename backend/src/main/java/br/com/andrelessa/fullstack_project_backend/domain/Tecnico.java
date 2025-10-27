package br.com.andrelessa.fullstack_project_backend.domain;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.andrelessa.fullstack_project_backend.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Tecnico extends Pessoa {
    private static final long serialVersionUID = 1L;

    @JsonIgnore // QUANDO PESQUISAR POR TECNICO NAO TRAZER A LISTA DE CHAMADOS
    @OneToMany(mappedBy="tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
       
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    

    
    
}
