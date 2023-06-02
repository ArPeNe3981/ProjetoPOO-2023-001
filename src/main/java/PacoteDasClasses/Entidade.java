/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteDasClasses;

/**
 *
 * @author Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 */
public abstract class Entidade {
    
    private Long id;
    private Integer excluida=0;

    //<editor-fold defaultstate="collapsed" desc="CONSTRUTORES">
    
     //==============Construtor padrão===============

    public Entidade() {
    }
    
     //==============Construtor sobrecarregado===============

    public Entidade(Long id) {
        this.id = id;
    }
    
    
    
//</editor-fold>
    
  
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS e SETTERS">
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getExcluida() {
        return excluida;
    }
    
    public void setExcluida(Integer excluida) {
        this.excluida = excluida;
    }  
    
    public Integer isExcluida() {
        return excluida;
    }


    
    
    //</editor-fold>




         
    

 

    public Integer isExcluded() {
        return excluida;
    }

    public void setExcluido(Integer v1) {
        this.excluida = v1;
    }
    
    
    
}
