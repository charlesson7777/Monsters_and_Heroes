//class represents a weapon item in a game
import java.util.ArrayList;
import java.util.List;
public class Weapon extends Item{

    protected int damageVal;
    protected int numHand;

    public Weapon(String[][] data) {
        super.name = data[0][0];
        super.cost = Integer.parseInt(data[0][1]);
        super.requiredLevel = Integer.parseInt(data[0][2]);
        this.damageVal = Integer.parseInt(data[0][3]);
        this.numHand = Integer.parseInt(data[0][4]);
    }
    Weapon(){

    }

    public int getNumHand() {
        return numHand;
    }

    public void setDamageVal(int damageVal) {
        this.damageVal = damageVal;
    }

    public int getDamageVal() {
        return damageVal;
    }

    public void setNumHand(int numHand) {
        this.numHand = numHand;
    }

    public String getInfo() {
        return "Weapon: " + name + ", Damage Value: " + damageVal;
    }
}
