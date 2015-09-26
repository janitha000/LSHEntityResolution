/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JanithaT
 */
public class NGram {
    
    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - n + 1; i++)
            ngrams.add(concat(charArray, i, i+n));
       
        return ngrams;
    }
    
    public static String concat(char [] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append(words[i]);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        for (String ngram : ngrams(2, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))
                System.out.println(ngram);
            System.out.println();
        }
    
}
