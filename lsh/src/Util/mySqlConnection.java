/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author JanithaT
 */
import DataStructure.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author JanithaT
 */
public class mySqlConnection {
    
        String JDBC_DRIVER ;  
        String DB_URL;
        String USER;
        String PASS ;
        String tableName ;
    
        public mySqlConnection(String DB,String user, String pwd, String table){
         JDBC_DRIVER = "com.mysql.jdbc.Driver";  
         DB_URL = "jdbc:mysql://localhost:3306/"+DB;
         USER = user;
         PASS = pwd;
         tableName = table;
    }
        
      public HashMap<String,Entity> getInvertedIndexData() throws SQLException{
          HashMap<String,Entity> test = new HashMap<>();
          Connection conn = null;
           conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
           String query = "SELECT * FROM " +tableName + " LIMIT 0, 2000";
           Statement st = conn.createStatement();
       
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
       
      // iterate through the java resultset
      while (rs.next()){ 

         test.put(rs.getString("author_id"), new Entity(rs.getString("author_id"), rs.getString("full_author"), rs.getString("title"), rs.getString("paper_id")));
         
        // print the results
       // System.out.format("%s, %s, %s\n",  firstName, lastName, city);
      }
               
             conn.close();  
//      test.put("AAA",new Entity("AAA", "Janitha", "Tennakoon", "Kandy"));
//       test.put("AAB",new Entity("AAB", "Vindya ", "Hemali", "Matara"));
//        test.put("AAC",new Entity("AAC", "Nadeeka", "Wickramasinghe", "Matara"));
//        test.put("AAD",new Entity("AAD", "Nadeeka", "Wickramasinghe", "Galle"));
//        test.put("AAE",new Entity("AAE", "Kavinda", "Herath", "Kandy"));
//        test.put("AAF",new Entity("AAF", "Janith", "Tennakoon", "Kandy"));
//       test.put("AAG",new Entity("AAG", "Kosala", "Tennaakoon", "Kandy"));
//           test.put("AAI",new Entity("AAI", "Ganitha", "Tennaakoon", "Kandy"));  
//           test.put("AAH",new Entity("AAH", "Janitha", "Tennakon", "Kandy"));
//           test.put("AAJ",new Entity("AAJ", "Janitha", "Tennakon", "Ambatenna"));
           return test;
           
           
      }
       public List<Entity> getData() throws SQLException{
           List<Entity> test = new ArrayList<Entity>();
           
           Connection conn = null;
           conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
           String query = "SELECT * FROM " +tableName + " LIMIT 0, 2000";
              
             // create the java statement
      Statement st = conn.createStatement();
       
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
       
      // iterate through the java resultset
      while (rs.next()){ 
//         en.setRecordID(rs.getString("RecordID"));
//         en.setFirstName(rs.getString("FirstName"));
//         en.setLastName(rs.getString("LastName"));
//         en.setCity(rs.getString("City"));
         
         //Boolean add = test.add(new Entity(rs.getString("RecID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("City")));
         test.add(new Entity(rs.getString("author_id"), rs.getString("full_author"), rs.getString("title"), rs.getString("paper_id")));
        // print the results
       // System.out.format("%s, %s, %s\n",  firstName, lastName, city);
      }
               
             conn.close();  
//             test.add(new Entity("AAA", "janitha", "tennakoon", "kandy"));
//       test.add(new Entity("vindya", "vindya ", "hemali", "matara"));
//        test.add(new Entity("AAC", "nadeeka", "wickramasinghe", "matara"));
//        test.add(new Entity("AAD", "nadeeka", "wickramasinghe", "galle"));
//        test.add(new Entity("AAE", "kavinda", "herath", "kandy"));
//        test.add(new Entity("AAF", "janith", "tennakoon", "kandy"));
//       test.add(new Entity("AAG", "kosala", "tennaakoon", "kandy"));
//             test.add(new Entity("AAI", "ganitha", "tennaakoon", "kandy"));  
//           test.add(new Entity("AAH", "janitha", "tennakon", "kandy"));
//           test.add(new Entity("AAJ", "janitha", "tennakon", "ambatenna"));
           return test;
       }
       
       public Entity getRecord(String recordID) throws SQLException{
           
           Connection conn = null;
           conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
           //String query = "SELECT * FROM " +tableName + " WHERE RecordID = 'AAA'";
           String query = "SELECT * FROM " + tableName + " WHERE RecordID = '" + recordID + "'" ;
            PreparedStatement prepStmt = conn.prepareStatement(query);
            //prepStmt.setString(1, recordID);
            ResultSet rs = prepStmt.executeQuery(query);
            Entity entity = null;
            //while (rs.next()){ 
                entity.setFirstName(rs.getString("FirstName"));
                entity.setLastName(rs.getString("LastName"));
                entity.setCity(rs.getString("City"));
                entity.setRecordID(recordID);
        
         
            // print the results
           //System.out.format("%s, %s, %s\n",  firstName, lastName, city);
      
           
             conn.close();  
            return entity;
       }
       /*public static void main(String[] args) throws SQLException {
           mySqlConnection connecton = new mySqlConnection("researchtest", "root", "jibtennakoon", "person");
           connecton.getData();
            
       }*/
}