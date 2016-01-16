/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.negocio;

import br.com.gestao.pizzaria.entidade.Cliente;
import br.com.gestao.pizzaria.excecao.PesquisaSemResultadoException;
import br.com.gestao.pizzaria.persistencia.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melot_000
 */
public class ClienteBO {

    public void inserir(Cliente cliente) throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserir(cliente);
    }

    public void alterar(Cliente cliente) throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.alterar(cliente);
    }

    public void excluir(int id) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.excluir(id);
    }

    public List<Cliente> buscarTodos() throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.buscarTodos();
    }

    public List<Cliente> pesquisar(String filtro, String palavraPesquisada) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaClientes = new ArrayList<>();
        List<Cliente> listaClientesFiltrada = new ArrayList<>();
        
        listaClientes = clienteDAO.buscarTodos();

        for (Cliente listaCliente : listaClientes) {

            if ("NOME".equals(filtro)) {
                if (listaCliente.getNome().contains(palavraPesquisada)
                    || listaCliente.getNome().contains(palavraPesquisada.toUpperCase())
                    || listaCliente.getNome().contains(palavraPesquisada.toLowerCase())
                    ||listaCliente.getNome().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaClientesFiltrada.add(listaCliente);
                }
            } else if ("CPF".equals(filtro)) {
                if (listaCliente.getCPF().contains(palavraPesquisada)){
                    listaClientesFiltrada.add(listaCliente);
                }
            } else {
                if (listaCliente.getRG().contains(palavraPesquisada)){
                    listaClientesFiltrada.add(listaCliente);
                }
            }
        }
        if (listaClientesFiltrada.size() > 0) {
            return listaClientesFiltrada;
        } else {
            throw new PesquisaSemResultadoException();
        }
    }
}