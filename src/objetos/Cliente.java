/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Cliente {
    private String CPF;
    private String nome;
    private Date vendaHora;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getVendaHora() {
        return vendaHora;
    }

    public void setVendaHora(Date vendaHora) {
        this.vendaHora = vendaHora;
    }
    
    
}
