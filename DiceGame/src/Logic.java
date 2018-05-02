import com.sun.org.apache.xerces.internal.xs.StringList;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Logic {
    private int round=0;
    private int winningScore = 40;
    int[] scoreList;
    int pNum = GameController.getPlayerNum();
    Dice dice = new Dice();

    public Logic() {
        game();
    }


    public boolean gameOver() {
        for (int i = 0; i < pNum; i++)
            if (scoreList[i] >= winningScore) {
                return true;
            }
        return false;
    }


    public void game() {
        scoreList = new int[pNum];

        do {

            round++;
            System.out.println(round+". round");

            for (int i = 0; i < pNum; i++) {
                dice.roll();
                scoreList[i] += dice.getTotal();
                System.out.println(GameController.getPlayerNames()[i]+" :"+scoreList[i]);
                if (gameOver()) {
                    print(TextClss.winGameMesg + GameController.getPlayerNames()[i]);
                    break;
                }
            }
            print(TextClss.sepGameLine);
        } while (!gameOver());
    }
    public void print(String string) {
        System.out.println(string);
    }
}

