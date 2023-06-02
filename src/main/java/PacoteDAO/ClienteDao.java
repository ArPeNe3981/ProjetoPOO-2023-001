/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteDAO;

import PacoteDAO.Dao;
import PacoteDAO.DbConnection;
import PacoteDasClasses.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 */
public class ClienteDao extends Dao<Cliente>{
    
        public static final String TABLE = "cliente";

        
        
        
//<editor-fold defaultstate="collapsed" desc="SAVE OR UPDATE">
            @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(id, cpf, nome, lixo)  values (default, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set id = ?, cpf = ?, nome = ?, lixo=? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Cliente e) {
        try {

            pstmt.setLong(1, e.getCpf());
            pstmt.setString(2, e.getNome());
            pstmt.setInt(3, e.getExcluida());
                
            
            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(1, e.getId());
                pstmt.setLong(2, e.getCpf());
                pstmt.setString(3, e.getNome());
                pstmt.setInt(4, e.getExcluida());
                pstmt.setLong(5, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="FINDERS">

//==========================Busca de um registro======================
    
    @Override
    public String getFindByIdStatment() {
        return "select id, cpf, nome, lixo"
                + " from cliente where id = ?";
        
    }

     @Override
    public Cliente findById(Long id) {
        
        Cliente cliente= new Cliente();
                   
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindByIdStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
             
            // Returns the respective object if exists
            if (resultSet.next()) {
                //return extractObject(resultSet);  //mudei aqui
                   
                cliente.setId(resultSet.getLong("id"));
                cliente.setCpf(resultSet.getLong("cpf"));
                cliente.setNome(resultSet.getString("nome"));            
                cliente.setExcluida(resultSet.getInt("lixo"));            
                           
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        
        return cliente;
        
    }
    
    //==========================Busca de todos os registros======================
    
    
    
    
    @Override
    public String getFindAllStatment() {
        return "select id, cpf, nome, lixo"
                + " from cliente"
                + " where lixo = 0";
    }
    
    
       @Override
    public List<Cliente> findAll() {
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllStatment())) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            
                    Cliente cliente= new Cliente();
                    
                cliente.setId(resultSet.getLong("id"));
                cliente.setCpf(resultSet.getLong("cpf"));
                cliente.setNome(resultSet.getString("nome"));            
                cliente.setExcluida(resultSet.getInt("lixo")); 
            
                clientes.add(cliente);
                
            }
            
            
            // Returns the respective object
            //return extractObjects(resultSet); 

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        
        
    
    
        return clientes;
    }
    
    
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="DELETAR REGISTRO">

    @Override
    public String getMoveToTrashStatement() {
        return "update " + TABLE + " set lixo=? where id = ?";
    }


    
      @Override
    public void moveToTrash(Cliente c1) {
        
            try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getMoveToTrashStatement())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, 1L);
            preparedStatement.setLong(2, c1.getId());
            
            
            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            //ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        
        
    }  
    
    
//</editor-fold>





 

   
    
    
    
    
    
}
