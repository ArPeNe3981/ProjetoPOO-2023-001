/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteDasClasses;

import java.time.LocalDate;

/**
 *
 * @author Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 */
public class Contrato extends Entidade {
    
//<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
   
    private String redacao;
    private LocalDate ultimaAtualizacao;
    private Cliente contratante;
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="CONSTRUTORES">
    public Contrato() {
    }

    public Contrato(Long id, String redacao, LocalDate ultimaAtualizacao, Cliente contratante) {
        super(id);
        this.redacao = redacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.contratante = contratante;
    }
    
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="GETTERS e SETTERS">
   
      
    public String getRedacao() {
        return redacao;
    }

    public void setRedacao(String redacao) {
        this.redacao = redacao;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
     
    public Cliente getContratante() {
        return contratante;
    }

    public void setContratante(Cliente contratante) {
        contratante.addContrato(this);
        this.contratante = contratante;
    }
    
    
    
    
    
    
    
    
//</editor-fold>


     @Override
    public String toString() {
        return "ID do Contrato: "+ this.getId() +
               "; pertence ao cliente de ID "+ this.getContratante().getId() +
               "; Ultima atualizacao:" + this.getUltimaAtualizacao()+
               "; Descrição: "+ this.getRedacao()+
               "; Lixeira: "+this.getExcluida();
    }
    
    

    
    
  
    
    
    
    
    
    
    
    
}
