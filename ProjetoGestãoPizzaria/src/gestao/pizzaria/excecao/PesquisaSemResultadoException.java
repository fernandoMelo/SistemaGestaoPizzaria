/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao.pizzaria.excecao;

/**
 *
 * @author melot_000
 */
public class PesquisaSemResultadoException extends GestaoPizzariaException {

    public PesquisaSemResultadoException() {
        super("A pesquisa não retornou nenhum resultado.");
    }
}
