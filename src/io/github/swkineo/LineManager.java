/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.swkineo;

import static io.github.swkineo.InputManager.conjState;
import io.github.swkineo.Objects.Day;

/**
 *
 * @author swkin_000
 */
public class LineManager {
    public static Day[] days = new Day[3];
    public static int dayNum = -1;
    
    // 0: Spanish, 1: English, 2: Description, 3: Conjugation, 4: Sub-Conj.
    public static int mode = -1;
    
    // finalText is only added to after each new day.
    public static String finalText = "";
    // tempText is appended to finalText on each refresh.
    public static String tempText = "";
    
    // TODO: Fix reset after Day 2.
    public static void addDay () {
        String dayString = "";
        if (dayNum != -1) {
            dayString = days[dayNum].toString ();
            dayString += "\n";
        }
        dayNum++;
        days[dayNum] = new Day ();
        finalText += dayString + "Day " + (dayNum + 1) + " {" + "\n";
        OutputPreview.preview.setText (finalText);
    }
    
    public static void addElement (String text1, String text2) {
        if (dayNum == -1) {
            System.out.println("Please start a new day.");
            return;
        }
        
        switch (mode) {
            case 0:
                days[dayNum].trans[days[dayNum].spTransNum].words[0] = text1;
                days[dayNum].spTransNum++;
                break;
            case 1:
                days[dayNum].trans[days[dayNum].enTransNum].words[1] = text1;
                days[dayNum].enTransNum++;
                break;
            case 2:
                days[dayNum].desc[days[dayNum].descNum] = text1;
                days[dayNum].descNum++;
                break;
            case 4:
                days[dayNum].trans[days[dayNum].subConjNum].words[0] = text1;
                days[dayNum].trans[days[dayNum].subConjNum].words[1] = text2;
                days[dayNum].subConjNum--;
                break;
            default:
                System.out.println("Please set a mode.");
                break;
        }
        output ();
    }
    
    public static void addConj (String conj) {
        switch (conjState) {
            case 0:
                days[dayNum].conj[days[dayNum].conjNum].conj[0] = conj;
                System.out.print("Tú Form: ");
                conjState++;
                break;
            case 1:
                days[dayNum].conj[days[dayNum].conjNum].conj[1] = conj;
                System.out.print("Él Form: ");
                conjState++;
                break;
            case 2:
                days[dayNum].conj[days[dayNum].conjNum].conj[2] = conj;
                System.out.print("Nos Form: ");
                conjState++;
                break;
            case 3:
                days[dayNum].conj[days[dayNum].conjNum].conj[3] = conj;
                System.out.print("Ellos Form: ");
                conjState++;
                break;
            case 4:
                days[dayNum].conj[days[dayNum].conjNum].conj[4] = conj;
                System.out.print("Yo Form: ");
                conjState = 0;
                days[dayNum].conjNum++;
                break;
            default:
                System.out.println("Error Occured: InputManager.conjState is" +
                        " out of bounds.");
                System.out.print("Yo Form: ");
                conjState = 0;
                break;
        }
    }
    
    public static void output () {
        if (mode == -1) return;
        tempText = days[dayNum].toString ();
        OutputPreview.preview.setText (finalText + tempText);
    }
    
}
