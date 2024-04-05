//This class represents a lightning spell item in a game

public class LightningSpell extends Item{
    protected double damageVal;
    protected double manaCost;


    public LightningSpell(String[][] data) {
        super.name = data.get(0)[0];
        super.cost = Integer.parseInt(data.get(0)[1]);
        super.requiredLevel = Integer.parseInt(data.get(0)[2]);
        this.damageVal = Integer.parseInt(data.get(0)[3]);
        this.manaCost = Integer.parseInt(data.get(0)[4]);
    }

    public double getDamageVal() {
        return damageVal;
    }

    public void setDamageVal(double damageVal) {
        this.damageVal = damageVal;
    }

    public double getManaCost() {
        return manaCost;
    }

    public void setManaCost(double manaCost) {
        this.manaCost = manaCost;
    }


    public String getInfo() {
        return "Lightning Spell: " + name + ", Damage Value: " + damageVal + "\n" +
                ", Mana Cost: " + manaCost;
    }

}

