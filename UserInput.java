/*
 * User input class to ensure user inputs have correct format / typing
 * I cant put the scanner object to be a member variable or else the loop doesnt
 * register the next line.
 */

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public int getDim() {
        boolean hasValid = false;
        int ret = 0;
        while (!hasValid) {
            try {
                ret = Integer.parseInt(scanner.nextLine());
                if (ret >= 1 && ret <= 9999) { // Modified minimum value to 1
                    hasValid = true;
                } else {
                    System.out.println("Invalid dimensions. Please enter a number between 1 and 9999."); // Modified error message
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return ret;
    }
    public String getColor() {
        String ret;
        while (true) {
            ret = scanner.nextLine();
            if (ret.equalsIgnoreCase("RED") || ret.equalsIgnoreCase("GREEN") || ret.equalsIgnoreCase("YELLOW")
                    || ret.equalsIgnoreCase("BLUE") || ret.equalsIgnoreCase("PURPLE") || ret.equalsIgnoreCase("CYAN")
                    || ret.equalsIgnoreCase("WHITE")) {
                return ret.toUpperCase();
            } else {
                System.out.println("Please enter a valid color (RED/GREEN/YELLOW/BLUE/PURPLE/CYAN/WHITE):");
            }
        }
    }

    public String getName() {
        return scanner.nextLine();
    }

    public int getTeams() throws IllegalArgumentException {
        int ret;
        while (true) {
            try {
                System.out.println("Enter the number of teams:");
                ret = Integer.parseInt(scanner.next());
                if (ret == 1) {
                    return ret;
                } else {
                    throw new IllegalArgumentException("Invalid number of teams. Please choose 1 team.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    public int getPlayersPerTeam() throws IllegalArgumentException {
        int ret;
        while (true) {
            try {
                System.out.println("Enter the number of players for the team:");
                ret = Integer.parseInt(scanner.next());
                if (ret == 1) {
                    return ret;
                } else {
                    throw new IllegalArgumentException("Invalid number of players. Please choose 1 player.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }



    public boolean getYN() {
        String input;
        while (true) {
            input = scanner.nextLine().toUpperCase();
            if (input.equals("Y") || input.equals("N")) {
                return input.equals("Y");
            } else {
                System.out.println("Please enter Y or N.");
            }
        }
    }

    public int getInt() {
        int ret;
        while (true) {
            try {
                ret = Integer.parseInt(scanner.nextLine());
                return ret;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public int getMove() {
        int ret;
        while (true) {
            try {
                ret = Integer.parseInt(scanner.nextLine());
                if (ret > 0 && ret < 100000000) {
                    return ret;
                } else {
                    System.out.println("Invalid number. Please enter a positive integer less than 100000000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public int getGame() {
        int ret;
        while (true) {
            System.out.println("Welcome!");
            System.out.println("Enter 1 to play Monsters and Heroes");
            System.out.println("Type quit at any time to exit");

            String input = scanner.nextLine().toUpperCase();
            if (input.equals("QUIT")) {
                System.out.println("Quit game");
                System.exit(0);
            }
            try {
                ret = Integer.parseInt(input);
                if (ret == 1) {
                    return ret;

                } else {
                    System.out.println("Please enter 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public String getDir() {
        String ret;
        while (true) {
            ret = scanner.nextLine().toUpperCase();
            if (ret.equals("W") || ret.equals("A") || ret.equals("S") || ret.equals("D")) {
                return ret;
            } else {
                System.out.println("Please enter W, A, S, or D.");
            }
        }
    }

    public int getMAndHDim() {
        int ret;
        while (true) {
            try {
                ret = Integer.parseInt(scanner.nextLine());
                if (ret >= 3 && ret <= 9999) {
                    return ret;
                } else {
                    System.out.println("Invalid dimensions. Please enter a number between 3 and 9999.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

}
