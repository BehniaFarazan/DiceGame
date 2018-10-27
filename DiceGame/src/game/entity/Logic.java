package game.entity;

import game.boundary.TextClss;

public class Logic {
    private int round = 0;
    private int winningScore = 40;
    private int[] scoreList;
    private int pNum = InputValidator.getPlayerNum();
    private Dice dice = new Dice();
    private int winnerScore;

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
        for (int i = 1; i < scoreList.length; i++) {
            if (scoreList[i] > scoreList[index]) {
                index = i;
            }
        }
        print(TextClss.winGameMesg + InputValidator.getPlayerNames()[index]);
        scoreList[index] = winnerScore;
        int count = 0;
        for (int i = 1; i < scoreList.length; i++) {
            if (scoreList[i] == winnerScore) {
                count++;
            }

        }
        if (count > 1) {
            print("There is a tie");
        }
       /* Dette virker også
        for (int i = 0; i < scoreList.length; i++) {
            index = scoreList[i] > scoreList[index] ? i : index;
        }*/

    }


    private void game() {
        scoreList = new int[pNum];

        do {

            round++;
            print(TextClss.roundShow(round));

            for (int i = 0; i < pNum; i++) {
                dice.roll();
                scoreList[i] += dice.getTotal();
                // System.out.println(GameController.getPlayerNames()[i] + " :" + scoreList[i]);
                print(TextClss.scoreShow(InputValidator.getPlayerNames()[i], scoreList[i]));
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

