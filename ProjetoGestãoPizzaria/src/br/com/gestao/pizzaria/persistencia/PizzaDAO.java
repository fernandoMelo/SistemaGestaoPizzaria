/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.persistencia;

import br.com.gestao.pizzaria.entidade.Pizza;
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
public class PizzaDAO {

    private static final String SQL_INSERT = "INSERT INTO PIZZA (NOME, INGREDIENTES, PRECO_P, PRECO_M, PRECO_G, PRECO_GG) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_BUSCAR_TODAS = "SELECT NOME, INGREDIENTES, PRECO_P, PRECO_M, PRECO_G, PRECO_GG, ID FROM PIZZA ORDER BY NOME";
    private static final String SQL_UPDATE = "UPDATE PIZZA SET NOME = ?, INGREDIENTES = ?, PRECO_P = ?, PRECO_M = ?, PRECO_G = ?, PRECO_GG = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM PIZZA WHERE ID = ? ";
    
    public void inserir(Pizza pizza) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, pizza.getNome());
            comando.setString(2, pizza.getIngredientes());
            comando.setDouble(3, pizza.getPrecoPequena());
            comando.setDouble(4, pizza.getPrecoMedia());
            comando.setDouble(5, pizza.getPrecoGrande());
            comando.setDouble(6, pizza.getPrecoGigante());

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

    public void alterar(Pizza pizza) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_UPDATE);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setString(1, pizza.getNome());
            comando.setString(2, pizza.getIngredientes());
            comando.setDouble(3, pizza.getPrecoPequena());
            comando.setDouble(4, pizza.getPrecoMedia());
            comando.setDouble(5, pizza.getPrecoGrande());
            comando.setDouble(6, pizza.getPrecoGigante());            
            comando.setInt(7, pizza.getId());

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

    public List<Pizza> buscarTodas() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Pizza> listaPizzas = new ArrayList<>();

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
                Pizza pizza = this.extrairLinhaResultadoBuscarTodas(resultado);
                //Adiciona um item à lista que será retornada
                listaPizzas.add(pizza);
            }
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return listaPizzas;
    }

    private Pizza extrairLinhaResultadoBuscarTodas(ResultSet resultado) throws SQLException {
        Pizza pizza = this.extrairLinhaResultado(resultado);
        return pizza;
    }

    private Pizza extrairLinhaResultado(ResultSet resultado) throws SQLException {
        //Instancia um novo objeto e atribui os valores vindo do BD
        //(Note que no BD o index inicia por 1)
        Pizza pizza = new Pizza();
        pizza.setNome(resultado.getString(1));
        pizza.setIngredientes(resultado.getString(2));
        pizza.setPrecoPequena(resultado.getDouble(3));
        pizza.setPrecoMedia(resultado.getDouble(4));
        pizza.setPrecoGrande(resultado.getDouble(5));
        pizza.setPrecoGigante(resultado.getDouble(6));
        pizza.setId(resultado.getInt(7));

        return pizza;
    }
}
