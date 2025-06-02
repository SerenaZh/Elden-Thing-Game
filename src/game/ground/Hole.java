package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.ShovelAction;

public class Hole extends Ground {
    public Hole() {
        super('O', "Hole");
        this.addCapability(Capabilities.TILLED);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        if (actor.hasCapability(Capabilities.SHOVELABLE)) {
            if (location.containsAnActor()) {
                if (location.getActor() == actor) {
                    actions.add(new ShovelAction());
                }
            }
        }
        return actions;
    }
}
