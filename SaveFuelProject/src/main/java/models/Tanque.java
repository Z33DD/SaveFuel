/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author J Nogueira
 */
public class Tanque {
    
    private long id;
    private double capacidade;
    private double cota;
    private double valorMedio;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getCota() {
        return cota;
    }

    public void setCota(double cota) {
        this.cota = cota;
    }

    public double getValorMedio() {
        return valorMedio;
    }

    public void setValorMedio(double valorMedio) {
        this.valorMedio = valorMedio;
    }
}
