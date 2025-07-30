import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MonstersAndHeroes extends BoardGame {
    private Board board;
    private int winner;
    private static int totalGames = 0;
    private UserInput userInput;

    public MonstersAndHeroes() {
        super();
        userInput = new UserInput();
    }

    @Override
    public String toString() {
        return null;
    }

    public void listOfHeroes(){
        System.out.println("(1): Warrior");
        System.out.println("(2): Sorcerer");
        System.out.println("(1): Paladin");

    }

    @Override
    public void start() {
        UserInput userInput1 = new UserInput();
        userInput1.getGame();
        System.out.println("Welcome to Monsters and Heroes");

        System.out.println("Enter the number of rows for the board:");
        int rows = userInput.getDim();
        System.out.println("Enter the number of columns for the board:");
        int cols = userInput.getDim();

        board = new Board(rows, cols);
        board.initializeBoard();

        System.out.println("How many teams will be playing?");
        int numTeams = userInput.getTeams();
        int numPlayers = userInput.getPlayersPerTeam();

        initializeTeams(numTeams, numPlayers);

        System.out.println(userInput1.getName() + "Are you ready to play? Choose Y or N");
        Boolean response = userInput.getYN();
        if (response) {
            play();
        } else {
            System.out.println("Come back later to enjoy my Monsters and Heroes Game");
            System.exit(0);
        }
    }
    public void play(){
        listOfHeroes();
        System.out.println("Which Hero do you like to be? choose 1 or 2 or 3");
        int choice = userInput.getInt();

        if(choice==1){

        }

    }
    // Method to check if a position is valid (within the bounds of the board)
    private boolean isValidPosition(int row, int col) {
        int numRows = board.getRows();
        int numCols = board.getCols();
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
    private void initializeTeams(int numTeams, int numPlayersPerTeam) {
        Player[][] teamsArray = new Player[numTeams][];
        String[] teamNames = new String[numTeams];

        for (int i = 0; i < numTeams; i++) {
            System.out.println("Enter name for team " + (i + 1) + ":");
            String teamName = userInput.getName();
            teamNames[i] = teamName;

            Player[] players = new Player[numPlayersPerTeam];

            for (int j = 0; j < numPlayersPerTeam; j++) {
                System.out.println("Enter name for player " + (j + 1) + " in team " + (i + 1) + ":");
                String playerName = userInput.getName();
                players[j] = new Player(playerName, teamName);
            }

            teamsArray[i] = players;
        }
        setTeams(new Teams(teamsArray, teamNames));
    }
}

