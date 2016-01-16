/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.persistencia;

import br.com.gestao.pizzaria.entidade.Bebida;
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
public class BebidaDAO {

    private static final String SQL_INSERT = "INSERT INTO BEBIDA (MARCA, SABOR, VOLUME, PRECO) VALUES (?, ?, ?, ?)";
    private static final String SQL_BUSCAR_TODAS = "SELECT MARCA, SABOR, VOLUME, PRECO, ID FROM BEBIDA ORDER BY MARCA";
    private static final String SQL_UPDATE = "UPDATE BEBIDA SET MARCA = ?, SABOR = ?, VOLUME = ?, PRECO = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM BEBIDA WHERE ID = ? ";
    
    public void inserir(Bebida bebida) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, bebida.getMarca());
            comando.setString(2, bebida.getSabor());
            comando.setString(3, bebida.getVolume());
            comando.setDouble(4, bebida.getPreco());

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

    public void alterar(Bebida bebida) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, bebida.getMarca());
            comando.setString(2, bebida.getSabor());
            comando.setString(3, bebida.getVolume());
            comando.setDouble(4, bebida.getPreco());
            comando.setInt(5, bebida.getId());

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

    public List<Bebida> buscarTodas() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Bebida> listaBebidas = new ArrayList<>();

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de consulta dos dados
            comando = conexao.prepareStatement(SQL_BUSCAR_TODAS);
            //Executa o comando e obtém o resultado da consulta
            resultado = comando.executeQuery();
            //O método next retornar boolean informando se existe um próximo
            //elemento para iterar
            while (resultado.next()) {
                Bebida bebida = this.extrairLinhaResultadoBuscarTodas(resultado);
                //Adiciona um item à lista que será retornada
                listaBebidas.add(bebida);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaBebidas;
    }

    private Bebida extrairLinhaResultadoBuscarTodas(ResultSet resultado) throws SQLException {
        Bebida bebida = this.extrairLinhaResultado(resultado);
        return bebida;
    }

    private Bebida extrairLinhaResultado(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Bebida bebida = new Bebida();
        bebida.setMarca(resultado.getString(1));
        bebida.setSabor(resultado.getString(2));
        bebida.setVolume(resultado.getString(3));
        bebida.setPreco(resultado.getDouble(4));
        bebida.setId(resultado.getInt(5));

        return bebida;
    }
}
