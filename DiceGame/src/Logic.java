import com.sun.org.apache.xerces.internal.xs.StringList;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Logic {
    private int round = 0;
    private int winningScore = 40;
    private int[] scoreList;
    private int pNum = GameController.getPlayerNum();
    private Dice dice = new Dice();
  
    public Logic() {
        game();
    }


    private boolean gameOver() {
        for (int i = 0; i < pNum; i++) {
            if (scoreList[i] >= winningScore) {

                return true;

            }
        }
        return false;
    }

    private void announceTheWinner() {
        int index = 0;
        for ( int i = 1; i < scoreList.length; i++ )
        {
            if ( scoreList[i] > scoreList[index] )
                index = i;
        }
       /* Dette virker også
        for (int i = 0; i < scoreList.length; i++) {
            index = scoreList[i] > scoreList[index] ? i : index;
        }*/
        print(TextClss.winGameMesg + GameController.getPlayerNames()[index]);
    }


    private void game() {
        scoreList = new int[pNum];

        do {

            round++;
            System.out.println(round + ". round");

            for (int i = 0; i < pNum; i++) {
                dice.roll();
                scoreList[i] += dice.getTotal();
                System.out.println(GameController.getPlayerNames()[i] + " :" + scoreList[i]);
            }
            gameOver();
            print(TextClss.sepGameLine);
        } while (!gameOver());
        announceTheWinner();
    }

    private void print(String string) {
        System.out.println(string);
    }
}

