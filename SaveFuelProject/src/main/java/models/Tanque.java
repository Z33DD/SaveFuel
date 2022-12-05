/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author J Nogueira
 */
@Entity
@Table(name = "Tanque")
public class Tanque {
    @Id
    private long id;
    @Column
    private double capacidade;
    @Column
    private double cota;
    @Column
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
