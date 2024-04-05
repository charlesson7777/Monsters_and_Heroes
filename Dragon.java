////This class represents a dragon entity in a game.
import java.util.List;
public class Dragon extends MonstersEntity {
    protected double baseDamageVal;
    protected double defenseVal;
    protected double dodgeAbility;

    //Constructor
    public Dragon(List<String[]> data) {
        super.name = data.get(0)[0];
        super.level = Integer.parseInt(data.get(0)[1]);
        super.hp = Integer.parseInt(data.get(0)[2]);
        this.baseDamageVal = Double.parseDouble(data.get(0)[3]);
        this.defenseVal = Double.parseDouble(data.get(0)[4]);
        this.dodgeAbility = Double.parseDouble(data.get(0)[5]);
    }

    //Getters and setters
    public double getBaseDamageVal() {
        return baseDamageVal;
    }

    public void setBaseDamageVal(double baseDamageVal) {
        this.baseDamageVal = baseDamageVal;
    }

    public void setDefenseVal(double defenseVal) {
        this.defenseVal = defenseVal;
    }

    public double getDefenseVal() {
        return defenseVal;
    }

    public double getDodgeAbility() {
        return dodgeAbility;
    }

    public void setDodgeAbility(double dodgeAbility) {
        this.dodgeAbility = dodgeAbility;
    }

    // Method to calculate the damage taken by the dragon after considering its defense value
    public void takeDamage(double damage) {
        double damageTaken = Math.max(0, damage - this.defenseVal * 0.1);
        this.hp = (int) Math.max(0, this.hp - damage);
    }

    public void displayStats() {
        System.out.println("Name: " + super.name);
        System.out.println("Level: " + super.level);
        System.out.println("HP: " + super.hp);
        System.out.println("Base Damage Value: " + this.baseDamageVal);
        System.out.println("Defense Value: " + this.defenseVal);
        System.out.println("Dodge Chance: " + this.dodgeAbility);
    }
}


