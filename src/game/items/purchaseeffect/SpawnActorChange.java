package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Collections;
import java.util.List;


public class SpawnActorChange implements PurchaseEffect{
    Actor entity;

    public SpawnActorChange(Actor entity) {
        this.entity = entity;
    }

    @Override
    public void applyEffect(Actor player, GameMap map) {
        Location playerLocation = map.locationOf(player);
        List<Exit> exits = playerLocation.getExits();

        // Shuffles a list
//        Collections.shuffle(exits);
        for (Exit exit: exits) {
            Location location = exit.getDestination();
            if (location.canActorEnter(player)) {
                location.addActor(entity);
                System.out.println(entity.toString() + " has spawned!");
                break;
            }

        }

    }
}
