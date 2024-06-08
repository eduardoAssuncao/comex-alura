package br.com.alura.DAOs;

import br.com.alura.entities.Categoria;
import br.com.alura.entities.DTOs.CategoriaDTO;
import br.com.alura.entities.DTOs.CategoriaGetNameDTO;
import br.com.alura.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CategoriaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    public void criar(CategoriaDTO dto){
        PreparedStatement ps;
        Categoria categoria = new Categoria(dto);

        String sql = "INSERT INTO tb_categoria (nome, descricao, ativo) VALUES (?,?,?)";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescricao());
            ps.setBoolean(3, true);

            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Set<CategoriaDTO> listar(){
        PreparedStatement ps;
        ResultSet rs;
        Set<CategoriaDTO> categorias = new HashSet<>();

        String sql = "SELECT * FROM tb_categoria WHERE ativo = true";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                Boolean ativo = rs.getBoolean(4);

                CategoriaDTO dto = new CategoriaDTO(nome, descricao);
                categorias.add(dto);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return categorias;
    }

    public List<CategoriaGetNameDTO> listarNomes(){
        PreparedStatement ps;
        ResultSet rs;
        LinkedList<CategoriaGetNameDTO> categorias = new LinkedList<>();

        String sql = "SELECT nome FROM tb_categoria WHERE ativo = true ORDER BY nome ASC";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString(1);

                CategoriaGetNameDTO dto = new CategoriaGetNameDTO(nome);
                categorias.addLast(dto);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return categorias;
    }

    public void atualizar(Integer id, CategoriaDTO dto){
        PreparedStatement ps;

        String sql = "UPDATE tb_categoria SET nome = ?, descricao = ? WHERE id = ?";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.nome());
            ps.setString(2, dto.descricao());
            ps.setInt(3, id);
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer id){
        PreparedStatement ps;

        String sql = "DELETE FROM tb_categoria WHERE id = ?";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletarLogico(Integer id){
        PreparedStatement ps;

        String sql = "UPDATE tb_categoria SET ativo = 0 WHERE id = ?";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
