package game.actor.npc;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.Curable;
import game.actions.CureAction;
import game.actor.RotEffect;
import game.behaviours.SelectBehaviour;
import game.behaviours.SelectPriorityBehaviour;
import game.utilities.BlessedUtils;

import java.util.List;

/**
 * Class representing the Spirit Goat that roams the land
 * Spirit Goat is a NonPlayableActor
 * @author Serena Zhou & Sandeesa R
 * Modified by Khushi R
 */
public class SpiritGoat extends SelectableBehaviourCreature implements Curable, ActorFactory {
    /**
     * Rot that effects the actor
     */
    private RotEffect rotEffect = new RotEffect(10);

    public SpiritGoat() {
        this(new SelectPriorityBehaviour());
    }
    /**
     * Constructor for the Spirit Goat
     */
    public SpiritGoat(SelectBehaviour selector) {
        super("Spirit Goat", 'y', 50, selector);
        this.addStatusEffect(new RotEffect(10));
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

    /**
     * Defines the behavior of the Spirit Goat each turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be executed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Location currentLocation = map.locationOf(this);

        // Check surroundings for blessed entities or grounds
        if (BlessedUtils.isSurroundedByBlessed(currentLocation)) {
            spawnOffspring(currentLocation, map);
        }

        // Proceed with default behavior
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Spawns a new Spirit Goat in a valid surrounding location.
     *
     * @param currentLocation the current location of the parent Spirit Goat
     * @param map             the game map
     */
    private void spawnOffspring(Location currentLocation, GameMap map) {
        List<Location> nearbyLocations = currentLocation.getExits().stream()
                .map(Exit::getDestination)
                .toList();

        // Find a valid location to spawn the new Spirit Goat
        for (Location loc : nearbyLocations) {
            if (loc.canActorEnter(this)) {
                loc.addActor(new SpiritGoat());
                break; // Only spawn one offspring
            }
        }
    }

    @Override
    public Actor createNewInstance() {
        return new SpiritGoat(this.getBehaviourSelector());
    }
}
