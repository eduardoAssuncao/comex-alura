package br.com.alura.entities;

import br.com.alura.entities.DTOs.CategoriaDTO;
import br.com.alura.entities.DTOs.ProdutoDTO;

public class Categoria {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean ativo;

    public Categoria(CategoriaDTO dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
