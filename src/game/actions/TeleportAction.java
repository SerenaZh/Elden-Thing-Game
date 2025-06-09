package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * <h1>TeleportAction</h1>
 * An action that allows an actor to teleport between different maps in the Elden Thing world.
 * <p>
 * This action enables instant travel between connected areas such as the Valley of Inheritree
 * and Limveld through teleportation circles. When executed, the actor is removed from their
 * current map and placed at the specified destination coordinates on the target map.
 * </p>
 * <p>
 * The teleportation is instantaneous and allows players to traverse the game world efficiently
 * without having to physically walk between distant locations.
 * </p>
 *
 * @author Khushi Rajpurohit
 */
public class TeleportAction extends Action {
    /**
     * The destination game map where the actor will be teleported to
     */
    private final GameMap destinationMap;
    /**
     * The x-coordinate of the destination location
     */
    private final int destX;
    /**
     * The y-coordinate of the destination location
     */
    private final int destY;

    /**
     * Constructor for TeleportAction.
     * Creates a teleport action that will move an actor to the specified coordinates
     * on the destination map.
     *
     * @param destinationMap the GameMap where the actor will be teleported to
     * @param destX the x-coordinate of the destination location
     * @param destY the y-coordinate of the destination location
     */
    public TeleportAction(GameMap destinationMap, int destX, int destY) {
        this.destinationMap = destinationMap;
        this.destX = destX;
        this.destY = destY;
    }

    /**
     * Executes the teleportation action.
     * Removes the actor from their current map and places them at the destination
     * coordinates on the target map.
     *
     * @param actor the actor performing the teleportation
     * @param map the current map where the actor is located
     * @return a string describing the successful teleportation
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        destinationMap.at(destX, destY).addActor(actor);
        return actor + " teleports to a new region!";
    }

    /**
     * Returns the menu description for this action.
     * This text is displayed to the player when they can perform this action.
     *
     * @param actor the actor who can perform this action
     * @return a string describing what the action does in the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters the teleportation circle";
    }
}