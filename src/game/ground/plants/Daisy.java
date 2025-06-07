package game.ground.plants;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.farming.WaterAction;
import game.ground.Plant;
import game.ground.Soil;

/**
 * A flower plant Daisy class
 *
 * @author Serena Zhou
 */
public class Daisy extends Ground implements Plant, Thirsty {
    /**
     * The default water level this Plant starts with
     */
    private int waterLevel = 25;

    /**
     * Saves the original water level for this plant
     */
    private final int originalWaterLevel;

    /**
     * Constructor
     */
    public Daisy() {
        super('d', "Daisy");
        this.originalWaterLevel = waterLevel;
        this.addCapability(Capabilities.CONSUMABLE);
    }

    /**
     * The allowable actions that this class can do
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return the actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Capabilities.WATERABLE)) {
            actions.add(new WaterAction(this));
        }
        return actions;
    }

    /**
     * Adds this plant to the ground
     * @param actor doing the planting
     * @param map of the Game
     * @return
     */
    @Override
    public boolean applyPlant(Actor actor, GameMap map) {
        map.locationOf(actor).setGround(this);
        return true;
    }

    /**
     * So this plant can experience the joy of time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        this.decreaseCounter();
        if (this.waterLevel <= 0) {
            location.setGround(new Soil());
        }
    }

    /**
     * Waters this plant by resetting the water level to full
     */
    @Override
    public void water() {
        this.waterLevel = originalWaterLevel;
    }

    /**
     * Decreases the water level
     */
    @Override
    public void decreaseCounter() {
        this.waterLevel -= 1;
    }
}
