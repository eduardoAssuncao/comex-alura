package br.com.alura.services;

import br.com.alura.DAOs.ProdutoDAO;
import br.com.alura.entities.DTOs.ProdutoDTO;
import br.com.alura.entities.DTOs.ProdutoGetNameDTO;

import java.util.List;
import java.util.Set;

public class ProdutoService {

    public void criar(ProdutoDTO dto){
        new ProdutoDAO().criar(dto);
    }

    public Set<ProdutoDTO> listar(){
        return new ProdutoDAO().listar();
    }

    public List<ProdutoGetNameDTO> listarNomes(){
        return new ProdutoDAO().listarNomes();
    }

    public void atualizar(Integer id, ProdutoDTO dto){
        new ProdutoDAO().atualizar(id, dto);
    }

    public void deletar(Integer id){
        new ProdutoDAO().deletar(id);
    }

    public void deletarLogico(Integer id){
        new ProdutoDAO().deletarLogico(id);
    }
}
