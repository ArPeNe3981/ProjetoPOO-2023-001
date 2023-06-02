/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.pooproj001arpene;

import PacoteDasClasses.Cliente;
import PacoteDAO.ClienteDao;
import PacoteDAO.ContratoDao;
import PacoteDasClasses.Contrato;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 */
public class Program {
    
    public static void main(String[] args) {
        
        
        
//<editor-fold defaultstate="collapsed" desc="Criação de objetos da classe Cliente">
        
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        
        c1.setNome("Ana Zaira");
        c1.setCpf(11929826303L);
        
        c2.setNome("Beatriz Yana");
        c2.setCpf(26752965030L);
        
        c3.setNome("Artur Pereira");
        c3.setCpf(46789502589L);

        
//</editor-fold>
       
//<editor-fold defaultstate="collapsed" desc="Salvando registros na tabela cliente do BD">

        System.out.println("   ");
        System.out.println("===>>> Inserção de CLIENTES no BD");        
        System.out.println("   "); 


        Long c1Id=new ClienteDao().saveOrUpdate(c1);
        c1.setId(c1Id);
        
        Long c2Id=new ClienteDao().saveOrUpdate(c2);
        c2.setId(c2Id);

        Long c3Id=new ClienteDao().saveOrUpdate(c3);
        c3.setId(c3Id);
        
  
        
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Update de dados nos registros de clientes no BD">

    System.out.println("   ");
    System.out.println("===>>> Update de informações na tabela CLIENTES do BD");        
    System.out.println("   "); 


    c1.setCpf(77733311100L);
    new ClienteDao().saveOrUpdate(c1);

//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="Recuperando um registro na tabela cliente">

        // Recuperar objeto recém-salvo
        System.out.println("   ");
        System.out.println("===>>> Recuperação de registros da tabela cliente por id");        
        System.out.println("   ");        

        Cliente c1Aux = new ClienteDao().findById(c1.getId());
        System.out.println("> " + (Cliente)c1Aux);
        
        Cliente c2Aux = new ClienteDao().findById(c2.getId());
        System.out.println("> " + (Cliente)c2Aux);


//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="Recuperando todos os registros na tabela cliente">

       // busca por tudo em clientes
       
        System.out.println("   ");
        System.out.println("===>>> Recuperação de todos os registros da tabela cliente");        
        System.out.println("   "); 
       

        ArrayList<Cliente> clientes=(ArrayList<Cliente>) new ClienteDao().findAll();
      
        for(int i=0;i<clientes.size();i++){
            System.out.println(clientes.get(i));
         } 

//</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc="Deletando registros da tabela cliente">

        System.out.println("   ");
        System.out.println("===>>> Deletar registro da tabela cliente");        
        System.out.println("   "); 


        c1Aux = new ClienteDao().findById(4L);
        System.out.println("> REGISTRO DE ID 4 " + (Cliente)c1Aux);
        new ClienteDao().moveToTrash(c1Aux);
        
        clientes=(ArrayList<Cliente>) new ClienteDao().findAll();
        for(int i=0;i<clientes.size();i++){
            System.out.println(clientes.get(i));
         }

//</editor-fold>






//<editor-fold defaultstate="collapsed" desc="Criação de objetos da classe Contrato">

    Contrato ct1=new Contrato();
    Contrato ct2=new Contrato();  
    Contrato ct3=new Contrato();
    Contrato ct4=new Contrato();  
    Contrato ct5=new Contrato(); 
    Contrato ct6=new Contrato();
    Contrato ct7=new Contrato();
    
    ct1.setRedacao("Contrato por tempo determinado");
    ct1.setUltimaAtualizacao(LocalDate.of(2023,5,21));
    ct1.setContratante(c1);

    ct2.setRedacao("Contrato por tempo indeterminado");
    ct2.setUltimaAtualizacao(LocalDate.of(2023,5,01));
    ct2.setContratante(c1);
    
    ct3.setRedacao("Contrato de trabalho eventual");
    ct3.setUltimaAtualizacao(LocalDate.of(2023,5,26));
    ct3.setContratante(c1);
    
    ct4.setRedacao("Contrato de estágio");
    ct4.setUltimaAtualizacao(LocalDate.of(2023,10,15));
    ct4.setContratante(c2);

    ct5.setRedacao("Contrato de experiência");
    ct5.setUltimaAtualizacao(LocalDate.of(2023,9,15));
    ct5.setContratante(c2);
    
    ct6.setRedacao("Contrato de teletrabalho");
    ct6.setUltimaAtualizacao(LocalDate.of(2023,8,17));
    ct6.setContratante(c2);

    ct7.setRedacao("Contrato intermitente");
    ct7.setUltimaAtualizacao(LocalDate.of(2023,7,15));
    ct7.setContratante(c2);
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Salvando Registros na tabela contrato do BD">

        System.out.println("   ");
        System.out.println("===>>> Inserção de CONTRATOS no BD");        
        System.out.println("   "); 


        Long ct1Id=new ContratoDao().saveOrUpdate(ct1);
        ct1.setId(ct1Id);
       
        Long ct2Id=new ContratoDao().saveOrUpdate(ct2);
        ct2.setId(ct2Id);        

        Long ct3Id=new ContratoDao().saveOrUpdate(ct3);
        ct3.setId(ct3Id);
        
        Long ct4Id=new ContratoDao().saveOrUpdate(ct4);
        ct4.setId(ct4Id);
        
        Long ct5Id=new ContratoDao().saveOrUpdate(ct5);
        ct5.setId(ct5Id);        

        Long ct6Id=new ContratoDao().saveOrUpdate(ct6);
        ct6.setId(ct6Id);

        Long ct7Id=new ContratoDao().saveOrUpdate(ct7);
        ct7.setId(ct7Id);        
        
        
        
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Update de dados nos registros de contrato no BD">

    System.out.println("   ");
    System.out.println("===>>> Update de informações na tabela CONTRATO do BD");        
    System.out.println("   "); 



    ct2.setRedacao("Esta é a redacao atualizada");
    new ContratoDao().saveOrUpdate(ct2);

//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="Recuperando um registro na tabela contrato">

        // Recuperar objeto recém-salvo
        System.out.println("   ");
        System.out.println("===>>> Recuperação de registros da tabela cliente por id");        
        System.out.println("   ");        

        Contrato ct1Aux = new ContratoDao().findById(ct1.getId());
        System.out.println("> " + (Contrato)ct1Aux);
        System.out.println("");
        Contrato ct2Aux = new ContratoDao().findById(ct2.getId());
        System.out.println("> " + (Contrato)ct2Aux);


//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Recuperando todos os registros na tabela contrato">

       // busca por tudo em clientes
       
        System.out.println("   ");
        System.out.println("===>>> Recuperação de todos os registros da tabela contrato");        
        System.out.println("   "); 
       

        ArrayList<Contrato> contratos=(ArrayList<Contrato>) new ContratoDao().findAll();
        for(int i=0;i<contratos.size();i++){
            System.out.println(contratos.get(i));
         } 

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Deletando registros da tabela contrato">

        System.out.println("   ");
        System.out.println("===>>> Deletar registro da tabela contrato");        
        System.out.println("   "); 


        ct1Aux = new ContratoDao().findById(4L);
        System.out.println("> contrato de ID 4 " + (Contrato)ct1Aux);
        new ContratoDao().moveToTrash(ct1Aux);
        
        contratos=(ArrayList<Contrato>) new ContratoDao().findAll();
        for(int i=0;i<contratos.size();i++){
            System.out.println(contratos.get(i));
        } 

//</editor-fold> 
 
        

        
        

        
        
        
        
        
    }
    
    
}
