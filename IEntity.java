public interface IEntity {
    public abstract HeroesEntity makeEntity(String name);

    //This clas represents an interface for inventory
    interface IInventory {
        boolean contains(Item item);
        Item removeItem(String itemName);
        Item getItem(String itemName);
        void printInventory();
        boolean isEmpty();
        int getSize();

        void addItem(Item item);

    }
}
