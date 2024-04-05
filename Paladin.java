//This class represents a paladin entity in a game

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Paladin extends HeroesEntity {
    protected int mp;
    protected int strength;
    protected double dexterityVal;
    protected double agilityVal;
    protected double goldAmount;
    protected int experience;
    protected List<Inventory> inventory;

    // Constructor
    public Paladin(String chosenCharacter) {
        super();
        FileReaderExample reader = new FileReaderExample();
        String[][] characterData = reader.readFile("Warriors.txt");

        for (String[] data : characterData) {
            if (data[0].equals(chosenCharacter)) {
                super.name = chosenCharacter;
                super.level = Integer.parseInt(data[1]);
                super.hp = Integer.parseInt(data[2]);
                this.mp = Integer.parseInt(data[3]);
                this.strength = Integer.parseInt(data[4]);
                this.dexterityVal = Double.parseDouble(data[5]);
                this.agilityVal = Double.parseDouble(data[6]);
                this.goldAmount = Double.parseDouble(data[7]);
                break;
            }
        }

        if (super.name == null) {

            super.name = "Unknown";
            super.level = 1;
            super.hp = 100;
            this.mp = 0;
            this.strength = 0;
            this.dexterityVal = 0.0;
            this.agilityVal = 0.0;
            this.goldAmount = 0.0;
        }
        this.inventory = new ArrayList<Inventory>();
    }
    public Paladin(String[][] data){

    }
    Weapon weapon = new Weapon();

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void setExperience(int experience) { this.experience = experience; }
    public int getExperience() { return level*10;}

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getDexterityVal() {
        return dexterityVal;
    }

    public void setDexterityVal(double dexterityVal) {
        this.dexterityVal = dexterityVal;
    }

    public double getAgilityVal() {
        return agilityVal;
    }

    public void setAgilityVal(double agilityVal) {
        this.agilityVal = agilityVal;
    }

    public void setGoldAmount(double goldAmount) {
        this.goldAmount = goldAmount;
    }

    public double getGoldAmount() {
        return goldAmount;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public void takeDamage(double damage) {
        super.hp -= damage;
        if (super.hp < 0) {
            super.hp = 0;
        }
    }
    public void revive() { this.hp = 100; }

    public void attack(String spell) {
        System.out.println("Casting spell: " + spell);
    }

    public void displayStats() {
        System.out.println("Name: " + super.name);
        System.out.println("Level: " + super.level);
        System.out.println("HP: " + super.hp);
        System.out.println("MP: " + this.mp);
        System.out.println("Strength: " + this.strength);
        System.out.println("Dexterity: " + this.dexterityVal);
        System.out.println("Agility: " + this.agilityVal);
        System.out.println("Gold: " + this.goldAmount);
    }


}
