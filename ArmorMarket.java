public class ArmorMarket extends MarketItem {
    private int damageReduction;

    public ArmorMarket(String name, int price, int level, int damageReduction) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }
}
