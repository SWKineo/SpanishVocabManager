/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.swkineo;

import io.github.swkineo.Objects.Day;



/**
 *
 * @author swkin_000
 */
public class InputManager {
    
    // 0: Yo, 1: Tu, 2: El, 3: Nos, 4: Ellos
    public static int conjState = 0;
    
    public static void manage (String in) {
        int i;
        if (0 == in.indexOf('/')) {
            String args = null;
            i = in.indexOf(' ');
            
            if (i > 0) {
                args = in.substring(i + 1);
                in = in.substring (0, i);
            }
            
            //System.out.println("cmd: " + in + ", args: " + args);
            CommandManager.input (in, args);
        } else {
            i = in.indexOf('-');
            in = accentManager(in, i);
            
            switch (LineManager.mode) {
                case 2:
                    // TODO: Add Logic
                    break;
                case 3:
                    LineManager.addConj(in);
                    break;
                case 4:
                    addSubConj (in);
                    break;
                default:
                    // foo is never used.
                    String foo = "";
                    LineManager.addElement (in, foo);
                    break;
            }
        }
    }
    
    public static void addSubConj (String in) {
        String word1, word2;
        int i = in.indexOf(' ');
        word1 = in.substring(0, i);
        word2 = in.substring(i + 1);
        LineManager.addElement (word1, word2);
    }

    // TODO: Commenting and Logic
    public static String accentManager (String word, int i) {
        if (i < 0) return word;
        
        return word;
    }
    
    //public static void debugTest () {
    //    System.out.println(LineManager.mode);
    //}
    
}
