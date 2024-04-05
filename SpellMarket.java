public class SpellMarket extends MarketItem {
    private int damage;
    private int manaCost;
    private SpellType spellType;

    public enum SpellType {
        FIRE,
        ICE,
        LIGHTNING
    }

    public SpellMarket(String name, int price, int level, int damage, int manaCost, SpellType spellType) {
        super(name, price, level);
        this.damage = damage;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }
}

