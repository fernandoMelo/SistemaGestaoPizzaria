/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.negocio;

import br.com.gestao.pizzaria.entidade.Caixa;
import br.com.gestao.pizzaria.excecao.CaixaAbertoException;
import br.com.gestao.pizzaria.persistencia.CaixaDAO;
import java.sql.SQLException;

/**
 *
 * @author melot_000
 */
public class CaixaBO {
  
    public void abrirCaixa(Caixa caixa) throws CaixaAbertoException, SQLException {
        try{
            verificaCaixaAberto();
        }catch(CaixaAbertoException e){
            if(!verificaSeCaixaFechado()){
                reabrirCaixa(caixa.getId());
                throw  new CaixaAbertoException("O Caixa estava fechado, e  foi iniciado.");
            }
        }
        CaixaDAO caixaDAO = new CaixaDAO();
        caixaDAO.abrirCaixa(caixa);
    }
    
    public void verificaCaixaAberto() throws CaixaAbertoException, SQLException{
        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa caixa = null;
        caixa = caixaDAO.buscarCaixaAtual();
        if(caixa != null){
            throw new CaixaAbertoException("O caixa já está aberto!");
        }        
    }
    
    public Caixa buscarDadosCaixaAtual() throws SQLException{
        CaixaDAO caixaDAO = new CaixaDAO();
        Caixa caixa = null;
        caixa = caixaDAO.buscarCaixaAtual();
        if(caixa == null){
            throw new CaixaAbertoException("O caixa de hoje não foi aberto");
        }
        return caixa;
    }
    
    public boolean verificaSeCaixaFechado() throws SQLException{
       CaixaDAO caixaDAO = new CaixaDAO();
       Caixa caixa = null;
       caixa = caixaDAO.buscarCaixaAtual();
       if(caixa == null){
           return true;
       }else{
           return caixa.getStatus();
       }
    }
    
    public void reabrirCaixa(int id) throws SQLException{
       CaixaDAO caixaDAO = new CaixaDAO();
       caixaDAO.reabrirCaixa(id);
    }
    
    public void fecharCaixa() throws SQLException{
        Caixa caixa = null;
        caixa = buscarDadosCaixaAtual();
        if(caixa != null){
            if(caixa.getStatus()){
                CaixaDAO caixaDAO = new CaixaDAO();
                caixaDAO.fecharCaixa(caixa.getId());
            }else{
                throw new CaixaAbertoException("O caixa já está contra fechado.");
            }    
        }else{
            throw new CaixaAbertoException("O caixa não está aberto hoje");
        }
    }
    
}
