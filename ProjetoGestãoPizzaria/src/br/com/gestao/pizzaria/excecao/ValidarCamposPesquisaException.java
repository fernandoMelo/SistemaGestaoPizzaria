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
public class ValidarCamposPesquisaException extends GestaoPizzariaException {

    public ValidarCamposPesquisaException() {
        super("Favor preencher o(s) campo(s) para realizar a pesquisa.");
    }
}
