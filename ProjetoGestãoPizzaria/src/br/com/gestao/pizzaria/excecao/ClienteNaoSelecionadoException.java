/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.excecao;

/**
 *
 * @author melot_000
 */
public class ClienteNaoSelecionadoException extends GestaoPizzariaException {

    public ClienteNaoSelecionadoException() {
        super("Cliente não selecionado. \n Selecione um cliente para pedido delivery.");
    }
}
