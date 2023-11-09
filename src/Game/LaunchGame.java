package Game;
import ConsoleInput.Console;
import Players.Player;

public class LaunchGame {
    int numberOfPlayers;
    Player [] player;

    {
        System.out.println("Welcome in quiz game!");
        numberOfPlayers = Console.getIntInput("Please set number of players: ");
        player = new Player[numberOfPlayers];
    }

    public void addPlayerToList(){
        for(int i = 0; i<numberOfPlayers; i++){
            System.out.println("There will be " + numberOfPlayers + " " + (numberOfPlayers>1?"players":"player"));
            String name = Console.getStringInput("Provide name of player " + (i+1));
            player[i]=new Player(1+i,name);
        }
    }

}
