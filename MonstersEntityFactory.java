import java.util.List;

public class MonstersEntityFactory extends FileReaderExample implements IEntity{
    public HeroesEntity makeEntity(String name) {
        HeroesEntity newEntity = null;

        String[][] data;
        switch (name.toLowerCase()) {
            case "dragon":
                data = FileReaderExample.readFile("Dragons.txt");
                newEntity = new Warrior(data);
                break;
            case "exoskeleton":
                data = FileReaderExample.readFile("Exoskeletons.txt");
                newEntity = new Sorcerer(data);
                break;
            case "spirit":
                data = FileReaderExample.readFile("Spirits.txt");
                newEntity = new Paladin(data);
                break;

            default:
                System.out.println("Unknown entity type.");
        }
        return newEntity;
    }
}


