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
            double l = getMaxElement(conj[i].conj);
            double titleLength = (double)conj[i].conj[0].length();
            // Centered is used to center the title on the Conjugation Chart.
            int centered = (int)((0.5 * l) - (0.5 * titleLength));
            
            char[] centering = new char[centered];
            Arrays.fill(centering, ' ');
            
            s += conj[i].conj[0];
        }
        
        return s + "}" + "\n";
    }
    
    // Returns the index of the largest element.
    private static int getMaxElement (String[] a) {
        int index = 1;
        int length = 0;
        int l;
        
        for (int i = 1; i < a.length; i++) {
            l = a[i].length();
            if (l > length) length = l;
            index = i;
        }
        
        return index;
    }
    
    // Centers a word relative to an array.
    private static String center (String word, int ref) {
        String s = "";
        
        // Creates the correct amount of spacing before the word.
        int center = (int)((0.5 * (ref)) - (0.5 * word.length()));
        char[] centering = new char[center];
        Arrays.fill(centering, ' ');
        String spaces = new String (centering);        
        
        s += spaces + word + spaces;
        
        return s;
    }
    
    public static void debugConjChart (String[] a) {
        String s = "";
        /* Each word needs to be centered on a bar that's 2 characters longer
           than the length of the longest word. Correction adds an exra space
           to the centering in a case of an odd max lenght.
        */
        int l = getMaxElement(a) + 2;
        
        // TODO: Make correction into a String[] with an element for each
        // conjugation. Redo the logic to accomadate for getMaxElemetn.
        String correction = "";
        if ((l % 2) == 1) correction = " ";
        String title;
        
        // Centers the title of the chart, considering the chart's shape.
        title = center(a[0], (2 * l) + 1);
        
        char[] frameArray = new char [l];
        Arrays.fill(frameArray, '-');
        String chartFrame = new String (frameArray);
        
        s += title + "\n";
        s += center(a[1], l) + correction + "|" + center(a[2], l) + "\n";
        s += chartFrame + "|" + chartFrame + "\n";
        s += center(a[3], l) + correction + "|" + center("X", l) + "\n";
        s += chartFrame + "|" + chartFrame + "\n";
        s += center(a[4], l) + correction + "|" + center(a[5], l) + "\n";
        
        System.out.println(s);
    }
}
