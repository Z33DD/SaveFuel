/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author J Nogueira
 */
public class Fornecimento {
    
    private long id;
    private Militar militar;
    private Fornecedor fornecedor;
    private Tanque tanque;
    private double precoPorLitro;
    private double quantidadeDeLitros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Militar getMilitar() {
        return militar;
    }

    public void setMilitar(Militar militar) {
        this.militar = militar;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
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
