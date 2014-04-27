/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.swkineo;

import java.util.Scanner;

/**
 *
 * @author swkin_000
 */
public class SpanishVocab {

    // The program ends when this is set to 'false'
    static boolean run = true;
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        OutputPreview.showFrame ();
        
        // The program will end if run is set to 'false'
        System.out.println ("Type /help for commands.");
        while (run = true) {
            InputManager.manage (reader.nextLine());
        }
    }
    
    
    
    
}
