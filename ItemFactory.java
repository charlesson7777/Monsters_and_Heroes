//class is responsible for creating instances of different types of items based on the provided name.
import java.io.File;
import java.util.List;

public class ItemFactory {
    public Item makeItem(String name) {
        Item newItem = null;

        String[][] data;
        switch (name.toLowerCase()) {
            case "weapon":
                data = FileReaderExample.readFile("Weaponry");
                newItem = new Weapon(data);
                break;
            case "armor":
                data = FileReaderExample.readFile("Armory.txt");
                newItem = new Armor(data);
                break;
            case "potion":
                data = FileReaderExample.readFile("Potions");
                newItem = new Potion(data);
                break;
            case "iceSpell":
                data = FileReaderExample.readFile("IceSpells.txt");
                newItem = new IceSpell(data);
                break;
            case "fireSpell":
                data = FileReaderExample.readFile("FireSpells.txt");
                newItem = new FireSpell(data);
                break;
            case "lightningSpell":
                data = FileReaderExample.readFile("LightningSpells.txt");
                newItem = new LightningSpell(data);
                break;
            default:
                System.out.println("Unknown entity type.");
        }
        return newItem;
    }
}
