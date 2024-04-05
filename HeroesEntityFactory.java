////class is responsible for creating instances of different types of entities based on the provided name

import java.util.List;

public class HeroesEntityFactory extends FileReaderExample implements IEntity{
    public HeroesEntity makeEntity(String name) {
        HeroesEntity newEntity = null;

        String[][] data;
        switch (name.toLowerCase()) {
            case "warriors":
                data = FileReaderExample.readFile("warriors.txt");
                newEntity = new Warrior(data);
                break;
            case "sorcerers":
                data = FileReaderExample.readFile("sorcerers.txt");
                newEntity = new Sorcerer(data);
                break;
            case "paladins":
                data = FileReaderExample.readFile("paladins.txt");
                newEntity = new Paladin(data);
                break;

            default:
                System.out.println("Unknown entity type.");
        }
        return newEntity;
    }
}

