/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.persistencia;

import br.com.gestao.pizzaria.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author melot_000
 */
public class ClienteDAO {

    private static final String SQL_INSERT = "INSERT INTO CLIENTE (NOME, CPF, RG, DATA_NASCIMENTO, SEXO, TELEFONE, ENDERECO) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_BUSCAR_TODOS = "SELECT NOME, CPF, RG, DATA_NASCIMENTO, SEXO, TELEFONE, ENDERECO, ID FROM CLIENTE ORDER BY NOME";
    private static final String SQL_UPDATE = "UPDATE CLIENTE SET NOME = ?, CPF = ?, RG = ?, DATA_NASCIMENTO = ?, SEXO = ?, TELEFONE = ?, ENDERECO = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM CLIENTE  WHERE ID = ? ";
    
    public void inserir(Cliente cliente) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCPF());
            comando.setString(3, cliente.getRG());           
            
            java.sql.Date data = new java.sql.Date(cliente.getDataNascimento().getTime());
            comando.setDate(4, data);
            
            String sexo = String.valueOf(cliente.getSexo());            
            comando.setString(5, sexo);
            
            comando.setString(6, cliente.getTelefone());
            comando.setString(7, cliente.getEndereco());

            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public void alterar(Cliente cliente) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCPF());
            comando.setString(3, cliente.getRG());
            
            java.sql.Date data = new java.sql.Date(cliente.getDataNascimento().getTime());
            comando.setDate(4, data);
            
            String sexo = String.valueOf(cliente.getSexo());            
            comando.setString(5, sexo);
            
            comando.setString(6, cliente.getTelefone());
            comando.setString(7, cliente.getEndereco());           
            comando.setInt(8, cliente.getId());

            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public void excluir(int id) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_DELETE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)            
            comando.setInt(1, id);

            //Executa o comando
            comando.execute();
            //Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
            //Caso aconteça alguma exeção é feito um rollback para o banco de
            //dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public List<Cliente> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Cliente> listaClientes = new ArrayList<>();

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_BUSCAR_TODOS);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Cliente cliente = this.extrairLinhaResultadoBuscarTodas(resultado);
                //Adiciona um item à lista que será retornada
                listaClientes.add(cliente);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaClientes;
    }

    private Cliente extrairLinhaResultadoBuscarTodas(ResultSet resultado) throws SQLException {
        Cliente cliente = this.extrairLinhaResultado(resultado);
        return cliente;
    }

    private Cliente extrairLinhaResultado(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Cliente cliente = new Cliente();
        cliente.setNome(resultado.getString(1));
        cliente.setCPF(resultado.getString(2));
        cliente.setRG(resultado.getString(3));
        
        java.sql.Date dataNascimento = resultado.getDate(4);
        cliente.setDataNascimento(new java.sql.Date(dataNascimento.getTime()));
        
        String sexo = resultado.getString(5);
        cliente.setSexo(sexo.charAt(0));
        
        cliente.setTelefone(resultado.getString(6));
        cliente.setEndereco(resultado.getString(7));
        cliente.setId(resultado.getInt(8));

        return cliente;
    }
}
