/*
 * Default teams class that is made up of a 2d array of Player objects
 */
public class Teams {
    private Player[][] teams;
    private String[] teamNames;
    private String[] teamColors;
    private int[] teamWins;

    public Teams(Player[][] team) {
        this.teams = team;
    }

    public Teams(Player[][] team, String[] teamNames, String[] teamColors) {
        this.teams = team;
        this.teamNames = teamNames;
        this.teamColors = teamColors;
        this.teamWins = new int[team.length]; // Initialize team wins array
    }

    public Teams(Player[][] team, String[] teamNames) {
        this.teams = team;
        this.teamNames = teamNames;
        this.teamColors = teamColors;
        this.teamWins = teamWins;
    }

    public Teams(Teams team) {
    }

    public Player getPlayerAt(int team, int num) {
        return teams[team][num];
    }

    public String getTeamName(int team) {
        return teamNames[team];
    }

    public String getTeamColors(int team) {
        return teamColors[team];
    }

    public int getTeamWins(int team) {
        return teamWins[team];
    }

    public void setTeamWins(int team, int wins) {
        teamWins[team] = wins;
    }

    // Additional methods for setting and updating team information
    public void setPlayerAt(int team, int num, Player player) {
        teams[team][num] = player;
    }

    public void setTeamName(int team, String name) {
        teamNames[team] = name;
    }

    public void setTeamColors(int team, String color) {
        teamColors[team] = color;
    }

    public int getNumPlayers(int team) {
        return teams[team].length;
    }

    public void addPlayerToTeam(int team, Player player) {
        for (int i = 0; i < teams[team].length; i++) {
            if (teams[team][i] == null) {
                teams[team][i] = player;
                return;
            }
        }
    }

    public void removePlayerFromTeam(int team, int playerIndex) {
        if (playerIndex >= 0 && playerIndex < teams[team].length) {
            teams[team][playerIndex] = null;
        }
    }
}
