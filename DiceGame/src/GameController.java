import java.util.Scanner;

public class GameController {

    public GameController() {
        welcomeMs();
        Logic logic = new Logic();
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
        print(TextClss.welcMesg);
        print(TextClss.playernumMesg);
        Scanner input = new Scanner(System.in);
        playerNum = input.nextInt();
        playerNames = new String[playerNum];
        System.out.println("The player number is " + playerNum);
        print(TextClss.sepMesgLine);
        int counter = 0;
        for (int i = 0; i < playerNum; i++) {
            counter++;
            System.out.println("What is the " + counter + ". players name?");
            Scanner cs = new Scanner(System.in);
            String name = cs.next();
            playerNames[i] = name;
            print(TextClss.sepMesgLine);
        }
    }

    public void print(String string) {
        System.out.println(string);
    }
}
