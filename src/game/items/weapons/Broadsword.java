package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.BuyAction;
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

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = super.allowableActions(otherActor, location);

        actionList.add(new BuyAction(this));
        return actionList;
    }
}
