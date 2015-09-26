/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataStructure.Entity;
import Util.EntitySimilarity;
import Util.mySqlConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JanithaT
 */
public class Comparison {
    HashMap<String,Entity> Entities;
    
    public ArrayList<Entity> getSimilarRecords(String query, ArrayList<String> candidates, double t1){
        Entities = getEntities();
        ArrayList<Entity> results = new ArrayList<>();
        //Entity OriginalEntity = Entities.get(query); //System.out.println(OriginalEntity.getRecordID() + " RECORD");
        Entity OriginalEntity = new Entity("Query", "A. Aamodt", "Case-Based Reasoning: Foundational issues, methodological variations, and system approaches", "");
        Set<String> candidateEntities = new HashSet<String>(candidates); 
        
        for (String candidate : candidateEntities) {
            Entity candidateEntity = Entities.get(candidate);
            System.out.println(OriginalEntity.getRecordID() + " "+ candidateEntity.getRecordID() +" " + EntitySimilarity.getSimilarity(OriginalEntity, candidateEntity, 0.4, 0.5, 0.1));
             if(EntitySimilarity.getSimilarity(OriginalEntity, candidateEntity, 0.4, 0.5, 0.1) > t1){
                        
                        results.add(candidateEntity);
                    }
             
        }
        
        
        return results;
    }
    
    public HashMap<String,Entity> getEntities(){
        HashMap<String,Entity> test = new HashMap<String, Entity>();
         mySqlConnection connecton = new mySqlConnection("csvimport", "root", "jibtennakoon", "citeseer");
                try {
                 
                    test = connecton.getInvertedIndexData();
                    //for (Entity en : test) {
                        //System.out.println("Record name " + en.getFirstName());
                    //}
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Comparison.class.getName()).log(Level.SEVERE, null, ex);
                }
                test.entrySet().stream().forEach((entry) -> {
                //System.out.print("Key : " + entry.getKey());
                Entity list = entry.getValue();
                
                //System.out.println(" " + list.getFirstName() );

            
            //System.out.println(entry.getKey().hashCode());
        });
                return test;
                
    }
    
}
