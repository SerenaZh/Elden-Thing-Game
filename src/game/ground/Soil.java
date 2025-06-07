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

    /**
     * The allowable actions that can be done to this soil
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return actions that can be done
     */
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
