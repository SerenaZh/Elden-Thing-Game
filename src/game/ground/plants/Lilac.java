package game.ground.plants;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.WaterAction;
import game.ground.Plant;
import game.ground.Soil;

public class Lilac extends Ground implements Plant, Thirsty {
    private int waterLevel = 10;
    private final int originalWaterLevel;

    public Lilac() {
        super('l', "Lilac");
        this.originalWaterLevel = waterLevel;
        this.addCapability(Capabilities.CONSUMABLE);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Capabilities.WATERABLE)) {
            actions.add(new WaterAction(this));
        }
        return actions;
    }

    @Override
    public boolean applyPlant(Actor actor, GameMap map) {
        map.locationOf(actor).setGround(this);
        return true;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.decreaseCounter();
        System.out.println(waterLevel);
        if (this.waterLevel <= 0) {
            location.setGround(new Soil());
        }
    }

    @Override
    public void water() {
        this.waterLevel = originalWaterLevel;
    }

    @Override
    public void decreaseCounter() {
        this.waterLevel -= 1;
    }
}
