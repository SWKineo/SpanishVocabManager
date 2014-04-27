/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.swkineo.Objects;

/**
 *
 * @author swkin_000
 */
public class Day {
    private final String transForm = "   -   ";
    
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
        for (int n = 0; n < 20; n++) {
            this.conj[n] = new Conjugation ();
        }
        
        this.trans = new Translation[200];
        for (int n = 0; n < 200; n++) {
            this.trans[n] = new Translation ();
        }
    }
    
    @Override
    public String toString () {
        String s = "";
        for (int i = 0; i < spTransNum || i < enTransNum; i++) {
            // ts (Spanish) and te (English) are purely for speed's sake.
            String ts = trans[i].words[0];
            String te = trans[i].words[1];
            
            //if (ts == null) ts = "";
            //if (te == null) te = "";
            s += ts + transForm + te + "\n";
        }
        return s + "}" + "\n";
    }
    
}
