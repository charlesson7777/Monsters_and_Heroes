//This class serves as an abstract base class for different entities in the game

import java.util.List;
import java.util.Random;

public class HeroesEntity {

    protected String name;

    protected int level;
    private int MAX_HP = 100;
    private int MIN_HP = 0;
    public int hp;
    private int mp;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isFainted() {
        return hp <= 0;
    }
    public void attack(MonstersEntityFactory target) {
        if (!equipWeapon(item)) {
            System.out.println(name + " cannot attack because no weapon is equipped.");
            return;
        }

        int damage = calculateDamage();

        target.receiveDamage(damage);

        System.out.println(name + " attacked " + target.getName() + " for " + damage + " damage!");
    }
    public void castSpell(int mpl) {
        if (isFainted()) {
            System.out.println(name + " is fainted and cannot perform actions.");
            return;
        }
        if (mp < mpl) {
            System.out.println(name + " does not have enough mana to cast the spell.");
            return;
        }
        Item spell = selectSpellToCast();

        mp -= mpl;

        applySpellEffects(spell);

        System.out.println(name + " cast " + spell.makeItem(name) + " spell.");
    }
    public Item selectSpellToCast() {

        Class<?>[] spellClasses = {FireSpell.class, IceSpell.class, LightningSpell.class};

        Random random = new Random();
        int index = random.nextInt(spellClasses.length);
        Class<?> selectedSpellClass = spellClasses[index];

        String[][] spellData = null;
        if (selectedSpellClass == FireSpell.class) {
            spellData = FileReaderExample.readFile("FireSpell.txt");
        } else if (selectedSpellClass == IceSpell.class) {
            spellData = FileReaderExample.readFile("IceSpell.txt");
        } else if (selectedSpellClass == LightningSpell.class) {
            spellData = FileReaderExample.readFile("LightningSpell.txt");
        }

        index = random.nextInt(spellData.length);

        String[] spellInfo = spellData[index];
        if (selectedSpellClass == FireSpell.class) {
            return new FireSpell(List.of());
        } else if (selectedSpellClass == IceSpell.class) {
            return new IceSpell(List.of());
        } else {
            return new LightningSpell((List<String[]>) List.of(spellInfo));
        }
    }

    // Method to apply spell effects
    private void applySpellEffects(Item spell) {

        if (spell instanceof ItemFactory) {
            System.out.println("Applying FireSpell effects.");
        } else if (spell instanceof ItemFactory) {
            System.out.println("Applying IceSpell effects.");
        } else if (spell instanceof ItemFactory) {
            System.out.println("Applying LightningSpell effects.");
        } else {
            System.out.println("Unknown spell type.");
        }
    }
    public int calculateDamage() {
        int baseDamage = strength + weapon.getDamageVal();
        return baseDamage;
    }
    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            die();
        } else {
            System.out.println(name + " received " + damage + " damage!");
        }
    }
    public void die() {
        if(isFainted())
            System.out.println("Warrior " + name + " has fainted.");

        BattleField.getCurrentBattle().removeWarrior(this);

        reviveWithHalfStats();

        BattleField.getCurrentBattle().checkBattleEnd();
    }
    public void reviveWithHalfStats() {
        hp = MAX_HP / 2;
        mp = MAX_MP / 2;

        System.out.println("Warrior " + name + " has been revived with half of their HP and mana.");
    }
    // Method to unequip an item
    public void unequipItem(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);

            switch (item.getName()) {
                case "weapon":
                    strength -= item.getBonus();
                    break;
                case "armor":
                    defense -= item.getBonus();
                    break;
                default:
                    System.out.println("Cannot unequip item: invalid item type.");
                    return;
            }

            System.out.println("Item " + item.getName() + " unequipped successfully.");
        } else {
            System.out.println("Item " + item.getName() + " is not equipped.");
        }
    }
    public void equipItem(Item item) {
        if (item.canEquip(item)) {
            if (!inventory.contains(item)) {
                // Add the item to the warrior's inventory
                inventory.add(item);
            }
            switch (item.getName()) {
                case "weapon":
                    strength += item.getBonus();
                    break;
                case "armor":
                    defense += item.getBonus();
                    break;
                default:
                    System.out.println("Cannot equip item: invalid item type.");
                    return;
            }

            System.out.println("Item " + item.getName() + " equipped successfully.");
        } else {
            System.out.println("Cannot equip item: item is not equipable.");
        }
    }

    // Method to sell an item to a store
    public void sellItem(Item item) {
        if (inventory.contains(item)) {
            goldAmount += item.getCost();

            inventory.remove(item);

            System.out.println("Item " + item.getName() + " sold successfully.");
        } else {
            System.out.println("Item " + item.getName() + " not found in inventory.");
        }
    }

    // Method to buy an item from a store
    public void buyItem(Item item) {
        if (goldAmount >= item.getCost()) {
            goldAmount -= item.getCost();
            inventory.add(item);

            System.out.println("Item " + item.getName() + " purchased successfully.");
        } else {
            System.out.println("Insufficient gold to buy item " + item.getName() + ".");
        }
    }
    public void castSpell( ItemFactory type) {
        if (isFainted()) {
            System.out.println(name + " is fainted and cannot perform actions.");
            return;
        }
        if (mp < spell.getManaCost()) {
            System.out.println(name + " does not have enough mana to cast " + spell.getName() + ".");
            return;
        }
        mp -= spell.getManaCost();

        spell.applyEffect(target);

        System.out.println(name + " cast " + spell.getName() + " on " + target.getName() + ".");
    }

    @Override
    public void usePotion(Potion potion) {
        if (isFainted()) {
            System.out.println(name + " is fainted and cannot perform actions.");
            return;
        }
        potion.applyEffect(this);

        inventory.remove(potion);

        System.out.println(name + " used " + potion.getName() + ".");
    }
    public void equipArmor(Armor armor) {
        this.armor = armor;
        System.out.println(name + " equipped " + armor.getName() + ".");
    }
    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(name + " equipped " + weapon.getName() + ".");
    }
    public boolean canEquip(Item item) {
        if (level < item.getRequiredLevel()) {
            System.out.println(name + " is not high enough level to equip " + item.getName() + ".");
            return false;
        }
        return true;
    }


}
