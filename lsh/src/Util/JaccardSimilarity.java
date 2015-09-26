/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JanithaT
 */
public class JaccardSimilarity {
    
        public static double getStringJaccardSimilarity(String[] string1, String[] string2) {
        
            if ((string1!=null && string2!=null) && (string1.length>0 || string2.length>0)) {
                List<String>x = Arrays.asList(string1);
                List<String>y = Arrays.asList(string2);
                if( x.size() == 0 || y.size() == 0 ) {
                    return 0.0;
                }

            Set<String> unionXY = new HashSet<String>(x);
            unionXY.addAll(y);

            Set<String> intersectionXY = new HashSet<String>(x);
            intersectionXY.retainAll(y);

            return (double) intersectionXY.size() / (double) unionXY.size();

            } else {
                    throw new IllegalArgumentException("The arguments x and y must be not NULL and either x or y must be non-empty.");
            }


            }
        
        public static double getQGramJaccardSimilarity(int[] tokens1, int[] tokens2) {
            double commonTokens = 0.0;
        int noOfTokens1 = tokens1.length;
        int noOfTokens2 = tokens2.length;
        for (int i = 0; i < noOfTokens1; i++) {
            for (int j = 0; j < noOfTokens2; j++) {
                if (tokens2[j] < tokens1[i]) {
                    continue;
                }

                if (tokens1[i] < tokens2[j]) {
                    break;
                }

                if (tokens1[i] == tokens2[j]) {
                    commonTokens++;
                }
            }
        }
        return commonTokens / (noOfTokens1 + noOfTokens2 - commonTokens);
        }

        public static void main(String[] args) {
            JaccardSimilarity JS = new JaccardSimilarity();
            Double sim = JS.getStringJaccardSimilarity("Janitha".split(""),"Vindya".split(""));
            System.out.println(sim);

        }
}