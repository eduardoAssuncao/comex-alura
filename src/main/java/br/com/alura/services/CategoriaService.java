package br.com.alura.services;


import br.com.alura.DAOs.CategoriaDAO;
import br.com.alura.entities.DTOs.CategoriaDTO;
import br.com.alura.entities.DTOs.CategoriaGetNameDTO;
import br.com.alura.entities.DTOs.ProdutoDTO;

import java.util.List;
import java.util.Set;

public class CategoriaService {

    public void criar(CategoriaDTO dto) {
        new CategoriaDAO().criar(dto);
    }

    public Set<CategoriaDTO> listar() {
        return new CategoriaDAO().listar();
    }

    public List<CategoriaGetNameDTO> listarNomes() {
        return new CategoriaDAO().listarNomes();
    }

    public void atualizar(Integer id, CategoriaDTO dto) {
        new CategoriaDAO().atualizar(id, dto);
    }

    public void deletar(Integer id) {
        new CategoriaDAO().deletar(id);
    }

    public void deletarLogico(Integer id) {
        new CategoriaDAO().deletarLogico(id);
    }
}
