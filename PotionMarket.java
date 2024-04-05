public class PotionMarket extends MarketItem {
    private int effectAmount;
    private String potionType;

    public PotionMarket(String name, int price, int level, int effectAmount, String potionType) {
        super(name, price, level);
        this.effectAmount = effectAmount;
        this.potionType = potionType;
    }

    public int getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(int effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getPotionType() {
        return potionType;
    }

    public void setPotionType(String potionType) {
        this.potionType = potionType;
    }
}

