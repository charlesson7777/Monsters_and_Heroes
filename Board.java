
import java.util.ArrayList;
import java.util.Collections;

//This class represents a game board with various types of tiles
public class Board {
    public Tile[][] board;
    protected int rows;
    protected int cols;


    // Constructors
    public Board(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        this.board = new Tile[rows][cols];
    }

    public Board(Tile [][] pieces){
        board = pieces;
        this.rows = pieces.length;
        this.cols = pieces[0].length;

    }
    //Method that initializes the board
    public void initializeBoard() {
        displayBoard();

    }
    //Method that displays the board
    public void displayBoard() {
        int totalOfTiles = rows * cols;
        int numCommonTiles = (totalOfTiles * 50 / 100) + 1;
        int numMarketPlaceTiles = totalOfTiles * 30 / 100;
        int numInaccessibleTiles = totalOfTiles * 20 / 100;

        ArrayList<String> sectionTypeTiles = new ArrayList<>();

        for (int i = 0; i < numInaccessibleTiles; i++) {
            sectionTypeTiles.add("%");
        }
        for (int i = 0; i < numMarketPlaceTiles; i++) {
            sectionTypeTiles.add("#");
        }
        for (int i = 0; i < numCommonTiles; i++) {
            sectionTypeTiles.add("&");
        }

        printSectionSymbols();
        System.out.println();

        Collections.shuffle(sectionTypeTiles);
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Tile(j, j, sectionTypeTiles.get(index));
                index++;
            }
        }

        printBoard();
    }
    // Method that prints symbols representing different types of sections on the board.
    public void printSectionSymbols() {
        System.out.println("(%) Non-innaccessible Section");
        System.out.println("(#) MarketPlace Section");
        System.out.println("(&) Common Section");
    }
    //Method that prints the current state of the board.
    public void printBoard() {
        System.out.println(toString());
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            return board[x][y];
        } else {
            return null;
        }
    }

    public void setTile(int x, int y, Tile tile) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            board[x][y] = tile;
        }
    }

    //Setters and getters
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }

    /*Method that returns a string representation of the current state
     of the board, including tile types and their colors*/
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Current Board:\n");

        for (int i = 0; i < rows; i++) {
            // Prints the top of the board
            result.append(String.join("", Collections.nCopies(cols, "+---"))).append("+\n");

            for (int j = 0; j < cols; j++) {
                Tile currentTile = board[i][j];
                // Prints the middle of the board with colors based on section type
                if (currentTile.getSectionType().equals("#")) {
                    result.append(Color.GREEN);
                } else if (currentTile.getSectionType().equals("%")) {
                    result.append(Color.RED);
                } else if (currentTile.getSectionType().equals("&")) {
                    result.append(Color.YELLOW);
                }
                result.append("| ").append(currentTile.getSectionType().charAt(0)).append(" ");
                result.append(Color.RESET);
            }
            result.append("|\n");
        }
        // Prints the bottom of the board
        result.append(String.join("", Collections.nCopies(cols, "+---"))).append("+\n");
        return result.toString();

    }
    public Tile getElement(int i, int j)
    {
        return board[i][j];
    }

    public void setElement(Tile piece, int i, int j)
    {
        board[i][j] = piece;
    }


}






