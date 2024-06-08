package br.com.alura.DAOs;

import br.com.alura.entities.DTOs.ProdutoDTO;
import br.com.alura.entities.DTOs.ProdutoGetNameDTO;
import br.com.alura.entities.Produto;
import br.com.alura.factory.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class ProdutoDAO {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    public void criar(ProdutoDTO dto){
        PreparedStatement ps;
        Produto produto = new Produto(dto);

        String sql = "INSERT INTO tb_produto (nome, descricao, valor, ativo) VALUES (?,?,?,?)";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValor());
            ps.setBoolean(4, true);

            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Set<ProdutoDTO> listar(){
        PreparedStatement ps;
        ResultSet rs;
        Set<ProdutoDTO> produtos = new HashSet<>();

        String sql = "SELECT * FROM tb_produto WHERE ativo = true";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                Double valor = rs.getDouble(4);
                Boolean ativo = rs.getBoolean(5);

                ProdutoDTO dto = new ProdutoDTO(nome, descricao, valor);
                produtos.add(dto);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public List<ProdutoGetNameDTO> listarNomes(){
        PreparedStatement ps;
        ResultSet rs;
        LinkedList<ProdutoGetNameDTO> produtos = new LinkedList<>();

        String sql = "SELECT nome FROM tb_produto WHERE ativo = true ORDER BY nome ASC";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString(1);
                ProdutoGetNameDTO dto = new ProdutoGetNameDTO(nome);
                produtos.addLast(dto);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public void atualizar(Integer id, ProdutoDTO dto){
        PreparedStatement ps;

        String sql = "UPDATE tb_produto SET nome = ?, descricao = ?, valor = ? WHERE id = ?";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.nome());
            ps.setString(2, dto.descricao());
            ps.setDouble(3, dto.valor());
            ps.setInt(4, id);
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer id){
        PreparedStatement ps;

        String sql = "DELETE FROM tb_produto WHERE id = ?";

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

        String sql = "UPDATE tb_produto SET ativo = 0 WHERE id = ?";

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
