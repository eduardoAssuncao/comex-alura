package br.com.alura.services;

import br.com.alura.DAOs.ClienteDAO;
import br.com.alura.entities.DTOs.ClienteDTO;
import br.com.alura.entities.DTOs.ClienteGetNameDTO;

import java.util.List;
import java.util.Set;

public class ClienteService {

    public void criar(ClienteDTO dto){
        new ClienteDAO().criar(dto);
    }

    public Set<ClienteDTO> listar(){
        return new ClienteDAO().listar();
    }

    public List<ClienteGetNameDTO> listarNomes(){
        return new ClienteDAO().listarNomes();
    }

    public void atualizar(Integer id, ClienteDTO dto){
        new ClienteDAO().atualizar(id, dto);
    }

    public void deletar(Integer id){
        new ClienteDAO().deletar(id);
    }

    public void deletarLogico(Integer id){
        new ClienteDAO().deletarLogico(id);
    }
}
