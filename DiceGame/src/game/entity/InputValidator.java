package game.entity;

import game.boundary.TextClss;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    Scanner sc = new Scanner(System.in);
    boolean bError = true;
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
        Scanner input = new Scanner(System.in);
        playerNum = input.nextInt();
        playerNames = new String[playerNum];
        print(TextClss.playerNumber(playerNum));
        print(TextClss.sepMesgLine);
        int counter = 0;
        for (int i = 0; i < playerNum; i++) {
            counter++;
            print(TextClss.nameThePlayer(counter));
            Scanner cs = new Scanner(System.in);
            String name = cs.next();
            playerNames[i] = name;
            print(TextClss.sepMesgLine);
        }

        }catch (Exception exp){
           print("Forkert input");
           welcomeMs();
       }
    }


    public static void inputValidator() {
     /*  do {
           System.out.println("Please enter a positive number!");
           while (!sc.hasNextInt()) {
               System.out.println("That's not a number!");
               sc.next(); // this is important!
           }
           number = sc.nextInt();
       } while (number <= 0);
       System.out.println("Thank you! Got " + number);*/
    }

    public void print(String string) {
        System.out.println(string);
    }
}
