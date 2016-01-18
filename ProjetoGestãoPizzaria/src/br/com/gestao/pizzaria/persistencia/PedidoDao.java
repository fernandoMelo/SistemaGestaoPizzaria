/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.persistencia;

import br.com.gestao.pizzaria.entidade.Bebida;
import br.com.gestao.pizzaria.entidade.ItemVenda;
import br.com.gestao.pizzaria.entidade.Pedido;
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
public class PedidoDAO {

    private static final String SQL_INSERT_PEDIDO = "INSERT INTO PEDIDO (ID_CLIENTE, VALOR_TOTAL) VALUES (?, ?)";
    private static final String SQL_SELECT_PEDIDO_ID = "SELECT ID FROM PEDIDO WHERE ID_CLIENTE = ?, VALORTOTAL = ?, DATA = CURRENT_DATE";
    private static final String SQL_INSERT_ITENS = "INSERT INTO ITENS_PEDIDO (ID_PEDIDO, ID_PIZZA, ID_BEBIDA, QUANTIDADE) VALUES (?, ?)";

    public void inserir(Pedido pedido, List<ItemVenda> itens) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {

            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(SQL_INSERT_PEDIDO);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, pedido.getIdCliente());
            comando.setDouble(2, pedido.getValorTotal());
            comando.execute();

            comando = conexao.prepareStatement(SQL_SELECT_PEDIDO_ID);

            comando.setInt(1, pedido.getIdCliente());
            comando.setDouble(2, pedido.getValorTotal());
            comando.execute();

            resultado = comando.executeQuery();
            while (resultado.next()) {
                pedido.setId(resultado.getInt(1));
            }

            comando = conexao.prepareStatement(SQL_INSERT_ITENS);
            for (ItemVenda item : itens) {
                comando.setInt(1, pedido.getId());
                comando.setInt(2, item.getIdPizza());
                comando.setInt(3, item.getIdBebida());
                comando.setInt(4, item.getQuantidade());
                comando.execute();
            }

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
}
