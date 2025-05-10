package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Collections;
import java.util.List;


public class SpawnActorChange implements PurchaseEffect{
    //Here we pass in static entity; refactor such that a NEW instance of entity is spawned each time not the same one.
    Actor entity;

    Actor spawnTarget;

    public SpawnActorChange(Actor entity) {
        this.entity = entity;
    }

    public void addSpawnTarget(Actor spawnTarget) {
        this.spawnTarget = spawnTarget;
    }

    @Override
    public void applyEffect(Actor player, GameMap map) {
        if (spawnTarget == null) {
            Location playerLocation = map.locationOf(player);
            List<Exit> exits = playerLocation.getExits();

            for (Exit exit: exits) {
                Location location = exit.getDestination();
                if (location.canActorEnter(player)) {
                    location.addActor(entity);
                    System.out.println(entity.toString() + " has spawned!");
                    break;
                }

            }
        } else {
            Location spawnLocation = map.locationOf(spawnTarget);
            List<Exit> exits = spawnLocation.getExits();

            for (Exit exit : exits) {
                Location location = exit.getDestination();
                if (location.canActorEnter(spawnTarget)) {
                    location.addActor(entity);
                    System.out.println(entity.toString() + " has spawned!");
                    break;
                }

            }
        }

    }
}
