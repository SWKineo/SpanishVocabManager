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
        for (int i = 0; i < 20; i++) {
            this.conj[i] = new Conjugation ();
        }
        
        this.trans = new Translation[200];
        for (int i = 0; i < 20; i++) {
            this.trans[i] = new Translation ();
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
        for (int i = 200; i > subConjNum; i--) {
            s += trans[i].words[0] + subConjForm + trans[i].words[1] + "\n";
        }
        
        // Print Conjugations
        for (int i = 0; i <= conjNum; i++) {
                /* Each word needs to be centered on a bar that's 2 characters longer
               than the length of the longest word. Correction adds an exra space
               to the centering in a case of an odd max lenght.
            */
            int l = conj[conjNum].conj[getMaxElement(conj[conjNum].conj)].length() + 2;
        
            String[] correction = new String[3];
        
            for (int i2 = 1; i2 < 4; i2++) {
                if (conj[conjNum].conj[i2].length() % 2 == 0) {
                    correction[i2 - 1] = " ";
                } else {
                    correction[i2 - 1] = "";
                }
            }
        
            String title;
        
            // Centers the title of the chart, considering the chart's shape.
            title = center(conj[conjNum].conj[0] + ":", (2 * l) + 3);
        
            char[] frameArray = new char [l];
            Arrays.fill(frameArray, '-');
            String chartFrame = new String (frameArray);
            
            s += title + ":" +"\n";
            s += center(conj[conjNum].conj[1], l) + correction[0] + "|" + center(conj[conjNum].conj[4], l) + "\n";
            s += chartFrame + "|" + chartFrame + "\n";
            s += center(conj[conjNum].conj[2], l) + correction[1] + "|" + center("X", l) + "\n";
            s += chartFrame + "|" + chartFrame + "\n";
            s += center(conj[conjNum].conj[3], l) + correction[2] + "|" + center(conj[conjNum].conj[5], l) + "\n";
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
            if (l > length)  {
                length = l;
                index = i;
            }
        }
        
        return index;
    }
    
    // Centers a word relative to an array.
    private static String center (String word, int ref) {
        String s = "";
        
        // Creates the correct amount of spacing before the word.
        int center = (int)(((0.5 * (ref)) - (0.5 * word.length())));
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
        int l = a[getMaxElement(a)].length() + 2;
        
        String[] correction = new String[3];
        
        for (int i = 1; i < 4; i++) {
            if (a[i].length() % 2 == 0) {
                correction[i - 1] = " ";
            } else {
                correction[i - 1] = "";
            }
        }
        
        String title;
        
        // Centers the title of the chart, considering the chart's shape.
        title = center(a[0] + ":", (2 * l) + 3);
        
        char[] frameArray = new char [l];
        Arrays.fill(frameArray, '-');
        String chartFrame = new String (frameArray);
        
        s += title + ":" +"\n";
        s += center(a[1], l) + correction[0] + "|" + center(a[4], l) + "\n";
        s += chartFrame + "|" + chartFrame + "\n";
        s += center(a[2], l) + correction[1] + "|" + center("X", l) + "\n";
        s += chartFrame + "|" + chartFrame + "\n";
        s += center(a[3], l) + correction[2] + "|" + center(a[5], l) + "\n";
        
        System.out.println(s);
    }
}
