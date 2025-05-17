package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.npc.ActorFactory;

import java.util.Collections;
import java.util.List;

/**
 * Class representing a PurchaseEffect which spawns an actor
 * @authors Serena Zhou & Aryan M
 */
public class SpawnActorChange implements PurchaseEffect{
    /**
     * Actor being spawned
     */
    private ActorFactory entity;
    /**
     * Actor around which the entity will spawn
     */
    private Actor spawnTarget;

    /**
     * Constructor
     *
     * @param entity Actor being spawned
     */
    public SpawnActorChange(ActorFactory entity) {
        this.entity = entity;
    }

    /**
     * Method for adding/identifying a target around which an entity should spawn
     * @param spawnTarget around which an entity should spawn
     */
    public void addSpawnTarget(Actor spawnTarget) {
        this.spawnTarget = spawnTarget;
    }

    /**
     * Applies the effects by spawning an actor onto the map
     * @param player affected
     * @param map in which effect takes place
     */
    @Override
    public void applyEffect(Actor player, GameMap map) {
        if (spawnTarget == null) {
            entitySpawn(player, map);
        } else {
            entitySpawn(spawnTarget, map);
        }

    }

    /**
     * Method for spawning a new instance of entity at every surrounding location (if possible)
     * @param spawnTarget around which an entity should spawn
     * @param map in which spawn takes place
     */
    private void entitySpawn(Actor spawnTarget, GameMap map) {
        Location spawnLocation = map.locationOf(spawnTarget);
        List<Exit> exits = spawnLocation.getExits();

        for (Exit exit : exits) {
            Location location = exit.getDestination();
            if (location.canActorEnter(spawnTarget)) {
                location.addActor(entity.createNewInstance());
                System.out.println(entity.toString() + " has spawned!");
                break;
            }
        }
    }

}
