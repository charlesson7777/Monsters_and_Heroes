import java.util.*;
public class Tile {
    private final int x;
    private final int y;
    private String sectionType;

    public Tile(int x, int y, String sectionType) {
        this.x = x;
        this.y = y;
        this.sectionType = sectionType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public boolean isAccessible() {
        return !sectionType.equals("inaccessible");
    }

    public boolean isMarket() {
        return sectionType.equals("market");
    }

    public boolean isCommon() {
        return sectionType.equals("common");
    }

    public static Tile askForPosition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the row for the position:");
        int x = scanner.nextInt();

        System.out.println("Enter the column for the position:");
        int y = scanner.nextInt();

        return new Tile(x, y, "");
    }
}
