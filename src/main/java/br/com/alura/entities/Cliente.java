package br.com.alura.entities;

import br.com.alura.entities.DTOs.ClienteDTO;

public class Cliente {

    //TODO: Adicionar Boolean para esclusão lógica
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private Boolean ativo;

    public Cliente(ClienteDTO dto){
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.nome = dto.nome();
    }

    public Cliente(Integer id, String nome, String cpf, String email, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
