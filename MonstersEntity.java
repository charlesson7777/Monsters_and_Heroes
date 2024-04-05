public abstract class MonstersEntity {

    protected String name;

    protected int level;
    private int MAX_HP = 100;
    private int MIN_HP = 0;
    public int hp;

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
    public void receiveDamage(int damage) {
        HeroesEntity entity = new HeroesEntity();
        hp -= damage;

        if (hp <= 0) {
            // If the hero's HP is 0 or below, call the die() method
            entity.die();
        } else {
            // If the hero's HP is still above 0, print a message indicating the damage received
            System.out.println(name + " received " + damage + " damage!");
        }
    }

}