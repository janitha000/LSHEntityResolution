/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DataStructure.Entity;

/**
 *
 * @author JanithaT
 */
public class EntitySimilarity {

    public static double getSimilarity(Entity entity1, Entity entity2, double weight1, double weight2, double weight3){
        double sim1 = JaccardSimilarity.getStringJaccardSimilarity(entity1.getFirstName().split(""), entity2.getFirstName().split(""));
        double sim2 = JaccardSimilarity.getStringJaccardSimilarity(entity1.getLastName().split(""), entity2.getLastName().split(""));
        double sim3 = JaccardSimilarity.getStringJaccardSimilarity(entity1.getCity().split(""), entity2.getCity().split(""));
        
            return weight1 * sim1 + weight2 * sim2 + weight3 * sim3;
        }
}

