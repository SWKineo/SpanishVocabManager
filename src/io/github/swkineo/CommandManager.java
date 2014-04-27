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
public class CommandManager {
    
    static InputManager inMgr;
    
    private static final String[] helpContents = {
        "/day   starts a new day.",
        "/sp    switches to Spanish words.",
        "/en    switches to English words.",
        //"/undo  erases the last given word.",
        //"/ch    displays the last five translations, to check for errors.",
        "/desc  switches to definitions.",
        "/conj  switches to conjugations.",
        "/ex    switches to sub-conjugations (the output is similar to /en" +
            " and /sp).",
        "/save  saves the document."
    };
    
    public static void input (String cmd, String args) {
        switch (cmd) {
            case "/help":
                getHelp ();
                break;
            case "/day":
                // Check in debug
                LineManager.addDay ();
                System.out.println ("Day " + (LineManager.dayNum + 1) + " added.");
                //inManager.debugTest ();
                break;
            case "/sp":
                LineManager.mode = 0;
                System.out.println ("Spanish Mode.");
                break;
            case "/en":
                LineManager.mode = 1;
                System.out.println ("English Mode.");
                break;
            case "/desc":
                LineManager.mode = 2;
                System.out.println ("Description Mode.");
                break;
            case "/conj":
                LineManager.mode = 3;
                System.out.print ("Yo Form: ");
                InputManager.conjState = 0;
                break;
            case "/ex":
                LineManager.mode = 4;
                System.out.println ("Sub-Conjugation Mode.");
                break;
            // TODO: Add cases for extra commands
            default:
                System.out.println ("Command not recognized. Please use /help" +
                        " for the command list.");
                break;
        }
        //inMgr.debugTest ();
    }
    
    public static void getHelp () {
        for (String helpContent : helpContents) {
            System.out.println(helpContent);
        }
        System.out.println ();
    }
    
}