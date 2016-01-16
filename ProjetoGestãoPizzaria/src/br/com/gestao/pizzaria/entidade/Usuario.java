/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.entidade;

/**
 *
 * @author melot_000
 */
public class Usuario {

    private String nome;
    private String nomeUsuario;
    private String senha;
    private int ID = -1;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeUsuario(String login) {
        this.nomeUsuario = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
