package game.items.weapons;

import game.Capabilities;
import game.items.Buyable;

public class DragonslayerGreatsword extends WeaponItem implements Buyable {

    public DragonslayerGreatsword(){
        super("Dragonslayer Greatsword", 'D', 70, "strikes", 75);
        this.addCapability(Capabilities.WEAPON);
    }

    @Override
    public void purchase() {
        System.out.println("WEEEE");
    }
}
