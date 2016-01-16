/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.negocio;

import br.com.gestao.pizzaria.entidade.Pizza;
import br.com.gestao.pizzaria.excecao.PesquisaSemResultadoException;
import br.com.gestao.pizzaria.persistencia.PizzaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melot_000
 */
public class PizzaBO {

    public void inserir(Pizza pizza) throws SQLException {

        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.inserir(pizza);
    }

    public void alterar(Pizza pizza) throws SQLException {

        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.alterar(pizza);
    }

    public void excluir(int id) throws SQLException {
        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.excluir(id);
    }

    public List<Pizza> buscarTodas() throws SQLException {
        PizzaDAO pizzaDAO = new PizzaDAO();
        return pizzaDAO.buscarTodas();
    }

    public List<Pizza> pesquisar(String filtro, String palavraPesquisada) throws SQLException {
        PizzaDAO pizzaDAO = new PizzaDAO();
        List<Pizza> listaPizzas = new ArrayList<>();
        List<Pizza> listaPizzasFiltrada = new ArrayList<>();
        
        listaPizzas = pizzaDAO.buscarTodas();

        for (Pizza listaPizza : listaPizzas) {

            if ("NOME".equals(filtro)) {
                if (listaPizza.getNome().contains(palavraPesquisada)
                    || listaPizza.getNome().contains(palavraPesquisada.toUpperCase())
                    || listaPizza.getNome().contains(palavraPesquisada.toLowerCase())
                    ||listaPizza.getNome().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaPizzasFiltrada.add(listaPizza);
                }
            } else {
                if (listaPizza.getIngredientes().contains(palavraPesquisada)
                    || listaPizza.getIngredientes().contains(palavraPesquisada.toUpperCase())
                    || listaPizza.getIngredientes().contains(palavraPesquisada.toLowerCase())
                    ||listaPizza.getIngredientes().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaPizzasFiltrada.add(listaPizza);
                }
            }
        }
        if (listaPizzasFiltrada.size() > 0) {
            return listaPizzasFiltrada;
        } else {
            throw new PesquisaSemResultadoException();
        }
    }
}