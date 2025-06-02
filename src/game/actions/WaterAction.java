package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ground.plants.Thirsty;

public class WaterAction extends Action {
    private Thirsty thirstyPlant;

    public WaterAction(Thirsty thirstyPlant) {
        this.thirstyPlant = thirstyPlant;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "";
    }
}
