package game.items.weapons;

import game.Capabilities;
import game.items.Buyable;

public class Katana extends WeaponItem implements Buyable {

    public Katana(){
        super("Katana", 'j', 50, "slices", 60);
        this.addCapability(Capabilities.WEAPON);
    }

    @Override
    public void purchase() {
        System.out.println("WEEEE");
    }
}
