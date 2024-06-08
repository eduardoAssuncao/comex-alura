package br.com.alura.entities;

import br.com.alura.entities.DTOs.ProdutoDTO;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Double valor;
    private Boolean ativo;

    public Produto(ProdutoDTO dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valor = dto.valor();
    }

    public Produto(Integer id, String nome, String descricao, Double valor, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", ativo=" + ativo +
                '}';
    }
}
