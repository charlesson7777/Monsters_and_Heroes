//class represents a potion item in a game
public class Potion extends Item {
    protected double effectAmount;

    public Potion(String[][] data) {
        super.name = data[0][0];
        super.cost = Integer.parseInt(data[0][1]);
        super.requiredLevel = Integer.parseInt(data[0][2]);
        this.effectAmount = Double.parseDouble(data[0][3]);
    }

    public double getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(double effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getInfo() {
        return "Potion: " + name + ", Effect Amount: " + effectAmount;
    }
}
