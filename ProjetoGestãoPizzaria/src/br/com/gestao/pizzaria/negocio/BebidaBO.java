/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.negocio;

import br.com.gestao.pizzaria.persistencia.BebidaDAO;
import br.com.gestao.pizzaria.entidade.Bebida;
import br.com.gestao.pizzaria.excecao.PesquisaSemResultadoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melot_000
 */
public class BebidaBO {

    public void inserir(Bebida bebida) throws SQLException {

        BebidaDAO bebidaDAO = new BebidaDAO();
        bebidaDAO.inserir(bebida);
    }

    public void alterar(Bebida bebida) throws SQLException {

        BebidaDAO bebidaDAO = new BebidaDAO();
        bebidaDAO.alterar(bebida);
    }

    public void excluir(int id) throws SQLException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        bebidaDAO.excluir(id);
    }

    public List<Bebida> buscarTodas() throws SQLException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        return bebidaDAO.buscarTodas();
    }

    public List<Bebida> pesquisar(String filtro, String palavraPesquisada) throws SQLException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        List<Bebida> listaBebidas = new ArrayList<>();
        List<Bebida> listaBebidasFiltrada = new ArrayList<>();
        
        listaBebidas = bebidaDAO.buscarTodas();

        for (Bebida listaBebida : listaBebidas) {

            if ("MARCA".equals(filtro)) {
                if (listaBebida.getMarca().contains(palavraPesquisada)
                    || listaBebida.getMarca().contains(palavraPesquisada.toUpperCase())
                    || listaBebida.getMarca().contains(palavraPesquisada.toLowerCase())
                    ||listaBebida.getMarca().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaBebidasFiltrada.add(listaBebida);
                }
            } else if ("SABOR".equals(filtro)) {
                if (listaBebida.getSabor().contains(palavraPesquisada)
                    || listaBebida.getSabor().contains(palavraPesquisada.toUpperCase())
                    || listaBebida.getSabor().contains(palavraPesquisada.toLowerCase())
                    ||listaBebida.getSabor().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaBebidasFiltrada.add(listaBebida);
                }
            } else {
                if (listaBebida.getVolume().contains(palavraPesquisada)
                    || listaBebida.getVolume().contains(palavraPesquisada.toUpperCase())
                    || listaBebida.getVolume().contains(palavraPesquisada.toLowerCase())
                    ||listaBebida.getVolume().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaBebidasFiltrada.add(listaBebida);
                }
            }
        }
        if (listaBebidasFiltrada.size() > 0) {
            return listaBebidasFiltrada;
        } else {
            throw new PesquisaSemResultadoException();
        }
    }
}