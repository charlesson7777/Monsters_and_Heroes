//This class represents a sorcerer entity in a game

import java.util.List;
import java.util.ArrayList;

public class Sorcerer extends HeroesEntity {
    protected int mp;
    protected int strength;
    protected double dexterityVal;
    protected double agilityVal;
    protected double goldAmount;
    protected int experience;
    //protected Position position;
    protected List<Inventory> inventory;

    public Sorcerer(List<String[]> data) {
        super.name = data.get(0)[0];
        super.level = Integer.parseInt(data.get(0)[1]);
        super.hp = Integer.parseInt(data.get(0)[2]);
        this.mp = Integer.parseInt(data.get(0)[3]);
        this.strength = Integer.parseInt(data.get(0)[4]);
        this.dexterityVal = Double.parseDouble(data.get(0)[5]);
        this.agilityVal = Double.parseDouble(data.get(0)[6]);
        this.goldAmount = Double.parseDouble(data.get(0)[7]);
        inventory = new ArrayList<>();
    }

    public Sorcerer(String[][] data){

    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void setExperience(int experience) { this.experience = experience; }
    public int getExperience() { return level*10;}
//    public Position getPosition(){ return position; }
//    public void setPosition(Position position) { this.position = position; }

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


