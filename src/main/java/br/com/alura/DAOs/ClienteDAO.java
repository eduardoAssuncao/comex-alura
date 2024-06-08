package br.com.alura.DAOs;

import br.com.alura.entities.Cliente;
import br.com.alura.entities.DTOs.ClienteDTO;
import br.com.alura.entities.DTOs.ClienteGetNameDTO;
import br.com.alura.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ClienteDAO {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    public void criar(ClienteDTO dto){
        PreparedStatement ps;
        Cliente cliente = new Cliente(dto);

        String sql = "INSERT INTO tb_cliente (nome, cpf, email, ativo) VALUES (?,?,?,?)";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setBoolean(4, true);

            ps.execute();
            ps.close();
            conn.close(); //Isso já é encerrado em algum momento?
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Set<ClienteDTO> listar(){
        PreparedStatement ps;
        ResultSet rs;
        Set<ClienteDTO> clientes = new HashSet<>();

        String sql = "SELECT * FROM tb_cliente WHERE ativo = true";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String email = rs.getString(4);

                ClienteDTO clienteDTO = new ClienteDTO(nome, cpf, email);
                clientes.add(clienteDTO);
            }

            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public List<ClienteGetNameDTO> listarNomes(){
        PreparedStatement ps;
        ResultSet rs;
        LinkedList<ClienteGetNameDTO> clientes = new LinkedList<>();

        String sql = "SELECT nome FROM tb_cliente WHERE ativo = true ORDER BY nome ASC";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString(1);
                ClienteGetNameDTO dto = new ClienteGetNameDTO(nome);
                clientes.addLast(dto);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public void atualizar(Integer id, ClienteDTO dto){
        PreparedStatement ps;

        String sql = "UPDATE tb_cliente SET nome = ?, cpf = ?, email = ? WHERE id = ?";

        try(Connection conn = connectionFactory.realizarConexao()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.nome());
            ps.setString(2, dto.cpf());
            ps.setString(3, dto.email());
            ps.setInt(4, id);
            ps.execute();

            ps.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer id){
        PreparedStatement ps;
        String sql = "DELETE FROM tb_cliente WHERE id = ?";

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

        String sql = "UPDATE tb_cliente SET ativo = 0 WHERE id = ?";

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
