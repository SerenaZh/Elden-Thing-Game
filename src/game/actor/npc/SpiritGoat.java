package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.Curable;
import game.actions.CureAction;
import game.actor.RotEffect;

/**
 * Class representing the Spirit Goat that roams the land
 * Spirit Goat is a NonPlayableActor
 * @author Serena Zhou
 */
public class SpiritGoat extends NonPlayableActor implements Curable {
    /**
     * Rot that effects the actor
     */
    private RotEffect rotEffect = new RotEffect(10);

    /**
     * Constructor for the Spirit Goat
     */
    public SpiritGoat() {
        super("Spirit Goat", 'y', 50 );
        this.addStatusEffect(rotEffect);
        this.addCapability(Capabilities.CURABLE);
    }

    /**
     * Cures the Spirit Goat
     * @param actor that is curing the goat
     * @param map of the Game
     * @return boolean if the goat can be cured
     */
    @Override
    public boolean cure(Actor actor, GameMap map) {
        this.rotEffect.resetTimer(10);
        return true;
    }

    /**
     * Gets the allowable actions that can be done to this Actor
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of Action objects that can be done to the Omen Sheep
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Capabilities.CURABLE)) {
            actions.add(new CureAction(this));
        }
        return actions;
    }
}
