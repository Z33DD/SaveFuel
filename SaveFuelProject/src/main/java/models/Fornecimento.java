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
@Table(name = "Fornecimento")
public class Fornecimento {
    @Id
    private long id;
    @Column
    private long militarId;
    @Column
    private long fornecedorId;
    @Column
    private long tanqueId;
    @Column
    private double precoPorLitro;
    @Column
    private double quantidadeDeLitros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMilitarId() {
        return militarId;
    }

    public void setMilitarId(long militarId) {
        this.militarId = militarId;
    }

    public long getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(long fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public long getTanqueId() {
        return tanqueId;
    }

    public void setTanqueId(long tanqueId) {
        this.tanqueId = tanqueId;
    }

    public double getPrecoPorLitro() {
        return precoPorLitro;
    }

    public void setPrecoPorLitro(double precoPorLitro) {
        this.precoPorLitro = precoPorLitro;
    }

    public double getQuantidadeDeLitros() {
        return quantidadeDeLitros;
    }

    public void setQuantidadeDeLitros(double quantidadeDeLitros) {
        this.quantidadeDeLitros = quantidadeDeLitros;
    }
}
