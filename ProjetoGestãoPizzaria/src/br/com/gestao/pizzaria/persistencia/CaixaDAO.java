/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.persistencia;

import br.com.gestao.pizzaria.entidade.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author melot_000
 */
public class CaixaDAO {
    
    private static String SQL_INSERT = "INSERT INTO CAIXA(VALOR_INICIAL, VALOR_FINAL) VALUES(?, ?)";
    private static String SQL_UPDATE_VALOR_FINAL = "UPDATE CAIXA SET VALOR_FINAL = VALOR_FINAL + ? WHERE ID = ?";
    private static String SQL_SELECT_CAIXA_ATUAL = "SELECT * FROM CAIXA WHERE DATA = CURRENT_DATE";
    private static String SQL_UPDATE_STATUS = "UPDATE CAIXA SET STATUS = true WHERE ID = ?";
    private static String SQL_UPDATE_FECHAR = "UPDATE CAIXA SET STATUS = FALSE WHERE ID = ?";
    
    public void abrirCaixa(Caixa caixa) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            comando.setDouble(1, caixa.getValorInicial());
            comando.setDouble(2, caixa.getValorInicial());
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
    
    public void updateValorFinal(int id, double valor) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE_VALOR_FINAL);
            comando.setDouble(1, valor);
            comando.setInt(2, id);
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
    public void reabrirCaixa(int id) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();        
            comando = conexao.prepareStatement(SQL_UPDATE_STATUS);
            comando.setInt(1, id);
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
    
    public Caixa buscarCaixaAtual() throws SQLException {
        Caixa caixa = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_CAIXA_ATUAL);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                caixa = new Caixa();
                caixa.setId(resultado.getInt(1));
                caixa.setData(resultado.getDate(2));
                caixa.setStatus(resultado.getBoolean(3));
                caixa.setValorInicial(resultado.getDouble(4));
                caixa.setValorFinal(resultado.getDouble(5));
            }

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

        return caixa;
    }
    
    public void fecharCaixa(int id) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();        
            comando = conexao.prepareStatement(SQL_UPDATE_FECHAR);
            comando.setInt(1, id);
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
    
}
