/*
 * BoardGame class as an abstract class for all types of board games
 * provides a constructor to set up the width and height of the board
 * Data members include a Board  and a teams.
 */
public abstract class BoardGame {
    private Board board;
    private Teams teams;
    private UserInput userInput;

    public BoardGame() {
        userInput = new UserInput();
    }
    public void setBoard(int rows, int cols) {
        board = new Board(rows, cols);
    }

    public void setBoard(Tile[][] pieces) {
        board = new Board(pieces);
    }

    public Board getBoard() {
        return board;
    }

    public void setTeams(Teams team) {
        teams = new Teams(team);
    }

    public void setTeams(Player[][] team, String[] teamNames, String[] teamColors) {
        teams = new Teams(team, teamNames, teamColors);
    }

    public Teams getTeams() {
        return teams;
    }

    public abstract String toString();

    public abstract void start();

}
