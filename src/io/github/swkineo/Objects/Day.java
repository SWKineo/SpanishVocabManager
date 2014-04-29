/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.swkineo.Objects;

import java.util.Arrays;

/**
 *
 * @author swkin_000
 */
public class Day {
    private final String transForm = "   <->   ";
    private final String subConjForm = "   ->   ";
    
    public int spTransNum;
    public int subConjNum;
    public int conjNum;
    public int descNum;
    public int enTransNum;
    
    //public static int lineGlobal = 0;
    
    public String[] desc;
    public Conjugation[] conj;
    // The translation object is used for both Translations and Sub-Conjugations
    public Translation[] trans;
    
    public Day () {
        this.spTransNum = 0;
        this.subConjNum = 200;
        this.conjNum = 0;
        this.descNum = 0;
        this.enTransNum = 0;
        
        this.desc = new String[10];
        
        this.conj = new Conjugation[20];
        for (Conjugation c : conj) {
            c = new Conjugation ();
        }
        
        this.trans = new Translation[200];
        for (Translation t : trans) {
            t = new Translation ();
        }
    }
    
    @Override
    public String toString () {
        String s = "";
        
        // Print Translations
        for (int i = 0; i < spTransNum || i < enTransNum; i++) {
            // ts (Spanish) and te (English) are purely for speed's sake.
            String ts = trans[i].words[0];
            String te = trans[i].words[1];
            //if (ts == null) ts = "";
            //if (te == null) te = "";
            s += ts + transForm + te + "\n";
        }
        
        // Print Descriptions
        for (int i = 0; i < descNum; i++) {
            s += "\n" + desc[i] + "\n";
        }
        
        // Print Sub-Conjugations
        for (int i = 200; i < subConjNum; i--) {
            s += trans[i].words[0] + subConjForm + trans[i].words[1] + "\n";
        }
        
        // Print Conjugations
        for (int i = 0; i < conjNum; i++) {
            double l = getMaxLength(conj[i].conj);
            double titleLength = (double)conj[i].conj[0].length();
            // Centered is used to center the title on the Conjugation Chart.
            int centered = (int)((0.5 * l) - (0.5 * titleLength));
            
            char[] centering = new char[centered];
            Arrays.fill(centering, ' ');
            
            s += conj[i].conj[0];
        }
        
        return s + "}" + "\n";
    }
    
    private static int getMaxLength (String[] a) {
        int l = 0;
        
        for (int i = 1; i < a.length; i++) {
            int length = a[i].length();
            if (length > l) l = length;
        }
        
        return l;
    }
    
    // Centers 
    private static String center (String word, int ref) {
        String s;
        
        return s;
    }
    
    public static void debugConjChart (String[] a) {
        String s = "";
        int l = getMaxLength(a);
        double titleLength = (double)a[0].length();
        String centered;
        
        centered = center(a[0], l);
        int center = (int)((0.5 * l) - (0.5 * titleLength));
        System.out.println("Centered = " + centered);
        
        char[] centering = new char[center];
        Arrays.fill(centering, ' ');
        
        char[] chartFrame = new char [l + 2] =
        
        s += new String (centering) + a[0] + "\n";
        s += ;
        
        System.out.println(s);
    }
}
