package game.boundary;

public class TextClss {
    public static String welcMesg = "Welcome to my DiceGame";
    public static String playernumMesg = "How many players want to participate: ";
    public static String sepMesgLine = "*----*----**----*----**----*----*";
    public static String sepGameLine = "#----#----##----#----##----#----#";
    public static String winGameMesg = "The winner is ";

    public static String nameThePlayer(int counter) {
        return "What is the " + counter + ". players name?";
    }
}
