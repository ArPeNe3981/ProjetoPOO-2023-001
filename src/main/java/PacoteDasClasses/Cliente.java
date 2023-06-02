/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteDasClasses;

import java.util.ArrayList;

/**
 *
 * @author Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 */
public class Cliente extends Entidade {
  
    //<editor-fold defaultstate="collapsed" desc="ATRIBUTOS">
    private long cpf;
    private String nome;
    private ArrayList<Contrato> listaDeContratos=new ArrayList<>();
    
    
//</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="CONSTRUTORES">

        //Construtor padrão
        public Cliente() {
        }
        
        //construtor sobrecarregado

    public Cliente(long id, long cpf, String nome) {
        super(id); 
        this.cpf = cpf;
        this.nome = nome;
    }
        
        


       
    
//</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    
    


    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Contrato> getListaDeContratos() {
        return listaDeContratos;
    }

    public void setListaDeContratos(ArrayList<Contrato> listaDeContratos) {
        this.listaDeContratos = listaDeContratos;
    }
    
    public void addContrato(Contrato c){
    
        this.listaDeContratos.add(c);
    }

    
    
    
    
//</editor-fold>

    @Override
    public String toString() {
        return "Id do cliente: "+this.getId()+ " Nome do cliente: "+ nome +"; CPF: "+cpf + "; Lixeira:" + super.getExcluida();
    }
    
    
    
 

    
    
    
    
    
    
}
