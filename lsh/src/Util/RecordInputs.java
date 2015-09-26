/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DataStructure.Entity;
import Main.Vector;
import static Util.NGram.ngrams;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JanithaT
 */
public class RecordInputs {

    List<Vector> data = new ArrayList<>();

    public List<Vector> getVectors(int numSets) {
        List<Entity> test = new ArrayList<>();
        mySqlConnection connecton = new mySqlConnection("csvimport", "root", "jibtennakoon", "citeseer");
        try {

            test = connecton.getData();
            //for (Entity en : test) {
            //System.out.println("Record name " + en.getFirstName());
            //}

        } catch (SQLException ex) {
            Logger.getLogger(RecordInputs.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        for (Entity entity : test) {
            //System.out.println(entity.getRecordID());
            all.add((ArrayList<String>) ngrams(2, entity.getFirstName().replace(" ", "").toLowerCase() + entity.getLastName().replace(" ", "").toLowerCase()));

        }

        ArrayList<String> uni = getUniversal();
        int count = 0;
        for (Entity entity : test) {
            double[] sig = new double[676];
            for (int j = 0; j < 676; j++) {

                if(all.get(count).contains(uni.get(j)))
                    sig[j] = 1.0;
                else
                    sig[j] = 0.0;
                

            }
            count++;
            data.add(new Vector(entity.getRecordID(), sig));
        }

        return data;

    }
    
    public Vector getQuery(String queryInput){
        Vector Query;
        ArrayList<String> All = new ArrayList<String>();
        All = (ArrayList<String>) ngrams(2, queryInput.toLowerCase());
        ArrayList<String> uni = getUniversal();
        int count = 0;
        double[] sig = new double[676];
            for (int j = 0; j < 676; j++) {

                if(All.contains(uni.get(j)))
                    sig[j] = 1.0;
                else
                    sig[j] = 0.0;
                
                
            }
            
            Query = new Vector("Query", sig);
            
            return Query;
        
        
        
    }

    public ArrayList<String> getUniversal() {
        String al =  /* "ABCDEFGHIJKLMNOPQRSTUVWYXZ";*/ "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> universal = new ArrayList<String>();
        char[] charArray = al.toCharArray();

        String str = null;
        for (char d : charArray) {
            //for(char f: charArray){
            for (char e : charArray) {
                StringBuilder sb = new StringBuilder();
                sb.append(d);
                //sb.append(f);
                sb.append(e);
                str = sb.toString();
                universal.add(str);
            }
            //}
        }
        return universal;
    }
}
