/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteDAO;


import PacoteDasClasses.Cliente;
import PacoteDasClasses.Contrato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 */
public class ContratoDao extends Dao<Contrato> {

    public static final String TABLE = "contrato";

//<editor-fold defaultstate="collapsed" desc="SAVE OR UPDATE">
    
      


    @Override
    public String getSaveStatment() {
      
        return "insert into "+ TABLE+ "( id,redacao,ultimaAtualizacao,idCliente,lixo) values (default, ?, ?, ?, ?)";
             
    }

    
    @Override
    public String getUpdateStatment() {
        
        return "update " + TABLE + " set id=?, redacao=?, ultimaAtualizacao=?, idCliente=?, lixo=?";
        
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Contrato e) {
    
        try {
                    
            pstmt.setString(1, e.getRedacao());
            pstmt.setObject(2, e.getUltimaAtualizacao(), java.sql.Types.DATE);         
            pstmt.setLong(3, e.getContratante().getId());
            pstmt.setInt(4, e.getExcluida());
            

            // Just for the update
            if (e.getId() != null) {    
            pstmt.setObject(1, e.getId());
            pstmt.setObject(2, e.getRedacao());
            pstmt.setObject(3, e.getUltimaAtualizacao(), java.sql.Types.DATE);
            pstmt.setObject(4, e.getContratante().getId());
            pstmt.setObject(5, e.getId());
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
        
        return "select id, redacao, ultimaAtualizacao, idcliente, lixo"
                + " from contrato where id = ?";
        
    }
    
    
    @Override
    public Contrato findById(Long id) {
       
        Cliente c1=new Cliente();
        Contrato contrato= new Contrato();
        contrato.setContratante(c1);
                   
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
                   
                contrato.setId(resultSet.getLong("id"));
                contrato.setRedacao(resultSet.getString("redacao"));             
//              contrato.setUltimaAtualizacao(LocalDate.parse(resultSet.getDate("ultimaAtualizacao")));                   
//              contrato.setUltimaAtualizacao(getDateFromTimestamp(resultSet.getString("ultimaAtualizacao")));
            
                contrato.getContratante().setId(resultSet.getLong("idCliente"));
                contrato.setExcluida(resultSet.getInt("lixo"));                
                           
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        
        return contrato;
        
    }
    
    
 //==========================Busca de todos os registro======================   
    
    @Override
    public String getFindAllStatment() {
        
        return "select id, redacao, ultimaAtualizacao, idCliente, lixo"
                + " from contrato"
                + " where lixo = 0";

    
    } 
    
    
    @Override
    public List<Contrato> findAll() {
        
        ArrayList<Contrato> contratos = new ArrayList<>();
        
        try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllStatment())) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            
                    
                Cliente c1=new Cliente();
                Contrato contrato= new Contrato();
                contrato.setContratante(c1);
                    
                contrato.setId(resultSet.getLong("id"));
                contrato.setRedacao(resultSet.getString("redacao"));
                contrato.getContratante().setId(resultSet.getLong("idCliente"));            
                contrato.setExcluida(resultSet.getInt("lixo")); 
            
                contratos.add(contrato);
                
            }
            
            
            // Returns the respective object
            //return extractObjects(resultSet); 

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        
        
    
    
        return contratos;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
//</editor-fold>    
   
//<editor-fold defaultstate="collapsed" desc="DELETAR REGISTRO">

    @Override
    public String getMoveToTrashStatement() {
        return "update " + TABLE + " set lixo=? where id = ?";
    }


    
      @Override
    public void moveToTrash(Contrato ct1) {
        
            try ( PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getMoveToTrashStatement())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, 1L);
            preparedStatement.setLong(2, ct1.getId());
            
            
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
        
       


    
    
    
  




 
    
    
    
    
    
    
    
    
    
    
    
    
        
   
        

