//This class is the inventory class for the items
import java.util.HashMap;

public class Inventory implements IInventory {
    private HashMap<String, Item> inventory;
    private int size;
    public Inventory() {
        this.inventory = new HashMap<>();
        this.size = 0;
    }

    public int getPrice(String itemName) {
        return inventory.get(itemName).getCost();
    }
    @Override
    public boolean contains(Item item) {
        return inventory.containsKey(item.getName());
    }

    @Override
    public Item removeItem(String itemName) {
        Item item = inventory.remove(itemName);
        if (item != null) {
            size--;
        }
        return item;
    }

    @Override
    public Item getItem(String itemName) {
        Item selectedItem = null;

        for (Item item : inventory.values()) {
            switch (itemName.toLowerCase()) {
                case "potion":
                    if (item instanceof Potion) {
                        selectedItem = item;
                    }
                    break;
                case "fireSpell":
                    if (item instanceof FireSpell) {
                        selectedItem = item;
                    }
                    break;
                case "iceSpell":
                    if (item instanceof IceSpell) {
                        selectedItem = item;
                    }
                    break;
                case "lightningSpell":
                    if (item instanceof LightningSpell) {
                        selectedItem = item;
                    }
                    break;
                case "weapon":
                    if (item instanceof Weapon) {
                        selectedItem = item;
                    }
                    break;
                case "armor":
                    if (item instanceof Armor) {
                        selectedItem = item;
                    }
                    break;
            }

            if (selectedItem != null) {
                break;
            }
        }

        return selectedItem;
    }

    @Override
    public void printInventory() {
        for (Item item : inventory.values()) {
            String itemType = "";

            if (item instanceof Potion) {
                itemType = "Potion";
            } else if (item instanceof FireSpell) {
                itemType = "fireSpell";
            }
            else if (item instanceof IceSpell) {
                itemType = "iceSpell";
            }
            else if (item instanceof LightningSpell) {
                itemType = "lighyningSpell";
            }
            else if (item instanceof Weapon) {
                itemType = "Weapon";
            } else if (item instanceof Armor) {
                itemType = "Armor";
            }

            System.out.println(itemType + ": " + item.getName());
        }
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void addItem(Item item) {
        inventory.put(item.getName(), item);
        size++;
    }
}
