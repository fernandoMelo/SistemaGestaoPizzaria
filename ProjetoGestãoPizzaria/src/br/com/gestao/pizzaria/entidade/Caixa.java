/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.entidade;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author melot_000
 */
public class Caixa {
    private int id;
    private boolean status;
    private double valorInicial;
    private double valorFinal;
    private Date data;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Caixa(){
        this.data = new Date(System.currentTimeMillis());
    }
        
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }    
    
    public String getValorFinalFormatado(){
        DecimalFormat formatador = new DecimalFormat("#,##0.00");
        return formatador.format(this.valorFinal);
    }
    
    public String getValorInicialFormatado(){
        DecimalFormat formatador = new DecimalFormat("#,##0.00");
        return formatador.format(this.valorInicial);
    }
    public String getDataFormatada(){
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        return dt.format(this.data);
    }
}
