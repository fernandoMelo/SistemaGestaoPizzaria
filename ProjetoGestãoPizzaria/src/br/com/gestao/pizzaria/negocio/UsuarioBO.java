/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.negocio;

import br.com.gestao.pizzaria.entidade.Usuario;
import br.com.gestao.pizzaria.excecao.PesquisaSemResultadoException;
import br.com.gestao.pizzaria.persistencia.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melot_000
 */
public class UsuarioBO {

    public void inserir(Usuario usuario) throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }
    
    public List<Usuario> buscarTodos() throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarTodos();
    }

    public void autenticar(Usuario usuario) throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.buscarUsuario(usuario.getNomeUsuario(), usuario.getSenha());

    }
    
    public void alterar(Usuario usuario) throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.alterar(usuario);
    }
    
    public void excluir(int id) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.excluir(id);
    }

    public String criptografarSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = null;
        messageDigest = algoritmo.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();

        return senhaCriptografada;
    }
    
    @SuppressWarnings("null")
    public List<Usuario> pesquisar(String filtro, String palavraPesquisada) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Usuario> listaUsuariosFiltrada = new ArrayList<>();

        listaUsuarios = usuarioDAO.buscarTodos();

        for (Usuario listaUsuario : listaUsuarios) {

            if ("NOME".equals(filtro)) {
                if (listaUsuario.getNome().contains(palavraPesquisada)
                    || listaUsuario.getNome().contains(palavraPesquisada.toUpperCase())
                    || listaUsuario.getNome().contains(palavraPesquisada.toLowerCase())
                    ||listaUsuario.getNome().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaUsuariosFiltrada.add(listaUsuario);
                }
            } else {
                if (listaUsuario.getNomeUsuario().contains(palavraPesquisada)
                    || listaUsuario.getNomeUsuario().contains(palavraPesquisada.toUpperCase())
                    || listaUsuario.getNomeUsuario().contains(palavraPesquisada.toLowerCase())
                    ||listaUsuario.getNomeUsuario().contains(palavraPesquisada.substring(0,1).toUpperCase().concat(palavraPesquisada.substring(1)))) 
                {
                    listaUsuariosFiltrada.add(listaUsuario);
                }
            }
        }
        if(listaUsuariosFiltrada.size() > 0) {
            return listaUsuariosFiltrada;
        } else {
            throw new PesquisaSemResultadoException();                    
        }
    }
}