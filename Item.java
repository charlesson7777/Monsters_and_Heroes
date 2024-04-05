//This class serves as an abstract base class for different types of items in a game

public abstract class Item {
    protected String name;
    protected int cost;
    protected int requiredLevel;

    // Getters
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    // Abstract method
    public abstract String getInfo();
}
