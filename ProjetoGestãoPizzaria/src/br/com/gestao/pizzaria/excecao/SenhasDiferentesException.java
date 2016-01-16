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
public class SenhasDiferentesException extends GestaoPizzariaException{
    
    public SenhasDiferentesException() {
        super("O conteudo dos campos senha e confirma senha estão diferentes.");
    }
}
