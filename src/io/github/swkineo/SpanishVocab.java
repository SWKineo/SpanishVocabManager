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
    public static String fileName;
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clearConsole ();
        Scanner reader = new Scanner (System.in);
        
        OutputPreview.showFrame ();
        
        // The program will end if run is set to 'false'
        System.out.print("What would you like to name the file?  ");
        fileName = reader.nextLine();
        clearConsole ();
        System.out.println ("Type /help for commands.");
        while (run = true) {
            InputManager.manage (reader.nextLine());
        }
    }
    
    public final static void clearConsole () {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
        //  Handle any exceptions.
        }
    }
       
}
