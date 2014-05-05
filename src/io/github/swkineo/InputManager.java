/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.swkineo;



/**
 *
 * @author swkin_000
 */
public class InputManager {
    
    // 0: Yo, 1: Tu, 2: El, 3: Nos, 4: Ellos
    public static int conjState = 0;
    public static String fileName;
    
    public static void manage (String in) {
        int i;
        // foo is never used.
        String foo = "";
                    
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
            in = accentManager(in);
            
            switch (LineManager.mode) {
                case 2:
                    // TODO: Add tool to close the window after a mode change.
                    LineManager.addElement (
                            accentManager(DescriptionWindow.descInput.getText ()), foo);
                    DescriptionWindow.descInput.setText("");
                    break;
                case 3:
                    LineManager.addConj(in);
                    break;
                case 4:
                    addSubConj (in);
                    break;
                default:
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
    public static String accentManager (String word) {
        for (int i = word.indexOf("-a"); i != -1; i = word.indexOf("-a")) {
            word = word.substring(0, i) + "á" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("-e"); i != -1; i = word.indexOf("-e")) {
            word = word.substring(0, i) + "é" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("-i"); i != -1; i = word.indexOf("-i")) {
            word = word.substring(0, i) + "í" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("-o"); i != -1; i = word.indexOf("-o")) {
            word = word.substring(0, i) + "ó" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("--u"); i != -1; i = word.indexOf("--u")) {
            word = word.substring(0, i) + "ü" + word.substring(i+3, word.length());
        }
        for (int i = word.indexOf("-u"); i != -1; i = word.indexOf("-u")) {
            word = word.substring(0, i) + "ú" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("-n"); i != -1; i = word.indexOf("-n")) {
            word = word.substring(0, i) + "ñ" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("-?"); i != -1; i = word.indexOf("-?")) {
            word = word.substring(0, i) + "¿" + word.substring(i+2, word.length());
        }
        for (int i = word.indexOf("-!"); i != -1; i = word.indexOf("-!")) {
            word = word.substring(0, i) + "¡" + word.substring(i+2, word.length());
        }
                                            
        return word;
    }
    
    //public static void debugTest () {
    //    System.out.println(LineManager.mode);
    //}
    
}
