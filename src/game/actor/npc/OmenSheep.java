package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.StatusEffect;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.Curable;
import game.actions.CureAction;
import game.actor.RotEffect;
import game.ground.Inheritree;

import java.util.List;

/**
 * Class representing the Omen Sheep that roams the land
 * Omen sheep is a NonPlayableActor
 * @author Serena Zhou
 */
public class OmenSheep extends NonPlayableActor implements Curable, ActorFactory {
    private StatusEffect rotEffect = new RotEffect(15);

    /**
     * Constructor for Omen Sheep
     */
    public OmenSheep() {
        super("Omen Sheep", 'm', 75 );
        this.addStatusEffect(rotEffect);
        this.addCapability(Capabilities.CURABLE);
    }

    /**
     * Cures the Omen Sheep
     * @param actor that is curing the Sheep
     * @param map of the Game
     * @return boolean if the sheep can be cured
     */
    @Override
    public boolean cure(Actor actor, GameMap map) {
        List<Exit> exits = map.locationOf(this).getExits();
        for (Exit exit: exits) {
            Location location = exit.getDestination();
            location.setGround(new Inheritree());
        }
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

    @Override
    public Actor createNewInstance() {
        return new OmenSheep();
    }
}
