package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.Curable;
import game.actions.CureAction;

/**
 * A class representing a blight covering the ground of the valley.
 * @author Adrian Kristanto
 * modified by Serena Zhou
 */
public class Blight extends Ground implements Curable {
    public Blight() {
        super('x', "Blight");
        this.addCapability(Capabilities.CURSED);
        this.addCapability(Capabilities.CURABLE);
    }

    /**
     * Cures the Blight by turning it into soil
     * @param actor that is curing the ground
     * @param map of the Game
     * @return boolean of if the Blight has been cured or not
     */
    @Override
    public boolean cure(Actor actor, GameMap map) {
        int staminaCost = 50;
        if (actor.getAttribute(BaseActorAttributes.STAMINA) < staminaCost) {
            return false;
        }

        Location location = map.locationOf(actor);
        location.setGround(new Soil());
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
        return true;
    }

    /**
     * A list of allowable actions that can be performed on the Blight
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return List of the actions that can be performed
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Capabilities.CURABLE)) {
            actions.add(new CureAction(this));
        }
        return actions;
    }
}
