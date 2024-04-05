/*
 * Default player class to keep track of various player information
 * such as name
 */
public class Player {
    private int row;
    private int col;
    private String name;
    private String team;

    public Player() {
        this.row = -1;
        this.col = -1;
        this.name = "";
        this.team = "";
    }

    public Player(int row, int col, String name, String team) {
        this.row = row;
        this.col = col;
        this.name = name;
        this.team = team;
    }
    public Player(String name, String team) {
        this.name = name;
        this.team = team;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "row=" + row +
                ", col=" + col +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
