//class represents a spirit entity in the game

import java.util.List;

public class Spirit extends MonstersEntity {
    protected double baseDamageVal;
    protected double defenseVal;
    protected double dodgeAbility;

    public Spirit(List<String[]> data) {
        super.name = data.get(0)[0];
        super.level = Integer.parseInt(data.get(0)[1]);
        super.hp = Integer.parseInt(data.get(0)[2]);
        this.baseDamageVal = Double.parseDouble(data.get(0)[3]);
        this.defenseVal = Double.parseDouble(data.get(0)[4]);
        this.dodgeAbility = Double.parseDouble(data.get(0)[5]);
    }

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

    public void takeDamage(double damage) {
        double damageTaken = Math.max(0, damage - this.defenseVal*0.1);
        this.hp = (int) Math.max(0, this.hp - damage);
    }


    public void attack(String attackType) {
        System.out.println("Performing " + attackType + " attack");
    }

    public void displayStats() {
        System.out.println("Name: " + super.name);
        System.out.println("Level: " + super.level);
        System.out.println("HP: " + super.hp);
        System.out.println("Base Damage Value: " + this.baseDamageVal);
        System.out.println("Defense Value: " + this.defenseVal);
        System.out.println("Dodge Chance: " + this.dodgeAbility);
    }

    public double hasWon() {
        // Logic to determine if the spirit has won
        return 0.0; // Placeholder return value
    }
}

