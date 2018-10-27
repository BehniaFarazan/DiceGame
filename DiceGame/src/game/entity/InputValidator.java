package game.entity;

import game.boundary.TextClss;

import java.util.Scanner;

public class InputValidator {

    public InputValidator() {
        welcomeMs();
    }

    public static int getPlayerNum() {
        return playerNum;
    }

    public static String[] getPlayerNames() {
        return playerNames;
    }

    private static int playerNum;
    private static String[] playerNames;


    public void welcomeMs() {
        try {
            print(TextClss.welcMesg);
            print(TextClss.playernumMesg);
            Scanner scanner = new Scanner(System.in);
            playerNum = scanner.nextInt();
            playerNames = new String[playerNum];
            print(TextClss.playerNumber(playerNum));
            print(TextClss.sepMesgLine);
            int counter = 0;
            for (int i = 0; i < playerNum; i++) {
                counter++;
                print(TextClss.nameThePlayer(counter));
                String name = scanner.next();
                playerNames[i] = name;
                print(TextClss.sepMesgLine);
            }

        } catch (Exception exp) {
            print("Forkert input");
            welcomeMs();
        }
    }

    public void print(String string) {
        System.out.println(string);
    }
}
