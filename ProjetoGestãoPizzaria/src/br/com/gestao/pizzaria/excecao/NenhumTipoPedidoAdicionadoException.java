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
public class NenhumTipoPedidoAdicionadoException extends GestaoPizzariaException {

    public NenhumTipoPedidoAdicionadoException() {
        super("Nenhum tipo de pedido adicionado.");
    }
}
