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
import game.behaviours.LayEggBehaviourForSheep;
import game.behaviours.SelectBehaviour;
import game.behaviours.SelectPriorityBehaviour;
import game.ground.Inheritree;

import java.util.List;

/**
 * Class representing the Omen Sheep that roams the land
 * Omen sheep is a NonPlayableActor
 * @author Serena Zhou
 * Modified by Khushi R
 */
public class OmenSheep extends SelectableBehaviourCreature implements Curable, ActorFactory {
    /**
     * Rot that effects the Actor
     */
    private StatusEffect rotEffect = new RotEffect(15);

    public OmenSheep() {
        this(new SelectPriorityBehaviour());
    }

    /**
     * Constructor for Omen Sheep
     */
    public OmenSheep(SelectBehaviour selector) {
        super("Omen Sheep", 'm', 75, selector);
        this.addStatusEffect(rotEffect);
        this.addCapability(Capabilities.CURABLE);
        this.behaviours.put(7, new LayEggBehaviourForSheep());
    }

    /**
     * Cures the Omen Sheep
     *
     * @param actor that is curing the Sheep
     * @param map   of the Game
     * @return boolean if the sheep can be cured
     */
    @Override
    public boolean cure(Actor actor, GameMap map) {
        List<Exit> exits = map.locationOf(this).getExits();
        for (Exit exit : exits) {
            Location location = exit.getDestination();
            location.setGround(new Inheritree());
        }
        return true;
    }

    /**
     * Gets the allowable actions that can be done to this Actor
     *
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of Action objects that can be done to the Omen Sheep
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Capabilities.CURABLE)) {
            actions.add(new CureAction(this));
        }
        return actions;
    }

    /**
     * Create a new instance of the current class
     *
     * @return Actor of the current class
     */
    @Override
    public Actor createNewInstance() {
        return new OmenSheep(this.getBehaviourSelector());
    }
}

