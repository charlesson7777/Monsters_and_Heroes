import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<MarketItem> itemsForSale;

    public Market() {
        itemsForSale = new ArrayList<>();
    }

    public void addItem(MarketItem item) {
        itemsForSale.add(item);
    }

    public boolean buyItem(HeroesEntityFactory hero, int itemIndex) {
        MarketItem item = itemsForSale.get(itemIndex);
        if (hero.getGoldAmount() >= item.getPrice() && hero.getLevel() >= item.getLevel()) {
            hero.getInventory().add(item);
            hero.setGoldAmount(hero.getGoldAmount() - item.getPrice());
            itemsForSale.remove(itemIndex);
            return true;
        } else {
            return false;
        }
    }

    public void sellItem(HeroesEntityFactory hero, int itemIndex) {
        MarketItem item = hero.getInventory().remove(itemIndex);
        hero.setGoldAmount(hero.getGoldAmount() + item.getPrice() / 2);
        itemsForSale.add(item);
    }
}

