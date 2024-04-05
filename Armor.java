//this class represents the Armors
public class Armor extends Item {
    protected double damageRedVal;
    protected int numHand;

    // Constructor
    public Armor(String[][] data) {
        super.name = data[0][0];
        super.cost = Integer.parseInt(data[0][1]);
        super.requiredLevel = Integer.parseInt(data[0][2]);
        this.damageRedVal = Double.parseDouble(data[0][3]);
    }

    // Getters and setters to set the armors and to retrieve them
    public double getDamageRedVal() {
        return damageRedVal;
    }

    public void setDamageRedVal(double damageRedVal) {
        this.damageRedVal = damageRedVal;
    }

    public int getNumHand() {
        return numHand;
    }

    public void setNumHand(int numHand) {
        this.numHand = numHand;
    }

    // Method to get information about the armor. It returns a string containing the armor's name and damage reduction value.
    public String getInfo() {
        return "Armor: " + name + ", Damage Reduction Value: " + damageRedVal;
    }
}


