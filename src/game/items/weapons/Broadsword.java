package game.items.weapons;

import game.Capabilities;
import game.items.Buyable;

public class Broadsword extends WeaponItem implements Buyable {

    public Broadsword(){
        super("Broadsword", 'b', 30, "slashes", 50);
        this.addCapability(Capabilities.WEAPON);
    }

    @Override
    public void purchase() {
        System.out.println("WEEEE");
    }
}
