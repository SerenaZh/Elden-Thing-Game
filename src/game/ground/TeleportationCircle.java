package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

/**
 * <h1>TeleportationCircle</h1>
 * A special ground type that allows actors to teleport between different game maps in Elden Thing.
 * <p>
 * This class represents a teleportation circle that connects the Valley of Inheritree to Limveld
 * and vice versa. When an actor stands on this ground, they can perform a teleport action to
 * travel instantly to the designated destination on another map. The teleportation is one-way
 * per circle - each circle has a fixed destination map and coordinates.
 * </p>
 * <p>
 * The teleportation circle is represented by the character 'A' on the game map and provides
 * seamless travel between different areas of the Elden Thing world.
 * </p>
 *
 * @author Khushi Rajpurohit
 */
public class TeleportationCircle extends Ground {
    /**
     * The destination game map where actors will be teleported to
     */
    private final GameMap destinationMap;

    /**
     * The x- and y-coordinate of the destination location
     */
    private final int destX, destY;

    /**
     * Constructor for TeleportationCircle.
     * Creates a teleportation circle that links to a specific destination on another map.
     *
     * @param destinationMap the GameMap where actors will be teleported to
     * @param x the x-coordinate of the destination location
     * @param y the y-coordinate of the destination location
     */
    public TeleportationCircle(GameMap destinationMap, int x, int y) {
        super('A', "Teleportation Circle");
        this.destinationMap = destinationMap;
        this.destX = x;
        this.destY = y;
    }

    /**
     * Returns the allowable actions that can be performed on this teleportation circle.
     * Provides a teleport action that allows actors to travel to the destination.
     *
     * @param actor the actor attempting to perform actions
     * @param location the current location of the teleportation circle
     * @param direction the direction from which the actor is approaching
     * @return ActionList containing the teleport action
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new TeleportAction(destinationMap, destX, destY));
        return actions;
    }
}

