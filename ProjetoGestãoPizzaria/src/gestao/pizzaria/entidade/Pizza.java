/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao.pizzaria.entidade;

/**
 *
 * @author melot_000
 */
public class Pizza {
    
    private String nome;
    private String Ingredientes;
    private double precoPequena;
    private double precoMedia;
    private double precoGrande;
    private double precoGigante;
    private int    id = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(String Ingredientes) {
        this.Ingredientes = Ingredientes;
    }

    public double getPrecoPequena() {
        return precoPequena;
    }

    public void setPrecoPequena(double precoPequena) {
        this.precoPequena = precoPequena;
    }

    public double getPrecoMedia() {
        return precoMedia;
    }

    public void setPrecoMedia(double precoMedia) {
        this.precoMedia = precoMedia;
    }

    public double getPrecoGrande() {
        return precoGrande;
    }

    public void setPrecoGrande(double precoGrande) {
        this.precoGrande = precoGrande;
    }

    public double getPrecoGigante() {
        return precoGigante;
    }

    public void setPrecoGigante(double precoGigante) {
        this.precoGigante = precoGigante;
    }
    
    
}
