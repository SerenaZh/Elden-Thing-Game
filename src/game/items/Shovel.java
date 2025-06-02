package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.ShovelAction;

public class Shovel extends Item {
    public Shovel() {
        super("Shovel", 'S',true);
        this.addCapability(Capabilities.SHOVELABLE);
    }

}
