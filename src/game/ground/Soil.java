package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.farming.ShovelAction;

/**
 * A class representing the soil in the valley
 * @author Adrian Kristanto
 * modified by Serena Zhou
 */
public class Soil extends Ground {
    /**
     * Constructor for Soil
     */
    public Soil() {
        super('.', "Soil");
        this.addCapability(Capabilities.PLANTABLE);
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
