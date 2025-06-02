package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;

public class Hole extends Ground {
    public Hole() {
        super('O', "Hole");
        this.addCapability(Capabilities.TILLED);
    }
}
