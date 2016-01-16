/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.persistencia;

import br.com.gestao.pizzaria.entidade.Usuario;
import br.com.gestao.pizzaria.excecao.SenhaIncorretaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melot_000
 */
public class UsuarioDAO {

    private static final String SQL_INSERT = "INSERT INTO USUARIO (NOME, NOME_USUARIO, SENHA) VALUES (?, ?, ?)";
    private static final String SQL_BUSCAR_USUARIO = "SELECT NOME_USUARIO, SENHA FROM USUARIO WHERE NOME_USUARIO = ?";
    private static final String SQL_BUSCAR_TODOS = "SELECT NOME, NOME_USUARIO, ID FROM USUARIO ORDER BY NOME ASC";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET NOME = ?, NOME_USUARIO = ?, SENHA = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM USUARIO WHERE ID = ? ";

    public void inserir(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_INSERT);

            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getNomeUsuario());
            comando.setString(3, usuario.getSenha());

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

    public void alterar(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getNomeUsuario());
            comando.setString(3, usuario.getSenha());
            comando.setInt(4, usuario.getID());

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

    @SuppressWarnings("null")
    public Usuario buscarUsuario(String nomeUsuario, String senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Usuario usuario = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCAR_USUARIO);
            comando.setString(1, nomeUsuario);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            if (resultado.next()) {
                usuario = this.extrairLinhaResultadoUsuario(resultado);
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        if (usuario.getNomeUsuario().equals(nomeUsuario) && (!usuario.getSenha().equals(senha))) {
            throw new SenhaIncorretaException();
        }
        return usuario;
    }

    private Usuario extrairLinhaResultadoUsuario(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(resultado.getString(1));
        usuario.setSenha(resultado.getString(2));

        return usuario;
    }

    public List<Usuario> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Usuario> listaUsuarios = new ArrayList<>();

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
                Usuario usuario = this.extrairLinhaResultadoBuscarTodas(resultado);
                //Adiciona um item à lista que será retornada
                listaUsuarios.add(usuario);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaUsuarios;
    }

    private Usuario extrairLinhaResultadoBuscarTodas(ResultSet resultado) throws SQLException {
        Usuario usuario = this.extrairLinhaResultado(resultado);
        return usuario;
    }

    private Usuario extrairLinhaResultado(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNome(resultado.getString(1));
        usuario.setNomeUsuario(resultado.getString(2));
        usuario.setID(resultado.getInt(3));

        return usuario;
    }
}
