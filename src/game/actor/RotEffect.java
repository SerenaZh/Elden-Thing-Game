package game.actor;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.StatusEffect;
import edu.monash.fit2099.engine.positions.Location;

public class RotEffect extends StatusEffect {
    private int rotCounter;

    public RotEffect(int rotCounter){
        super("Rotting");
        this.rotCounter = rotCounter + 1;
    }

    /**
     * Inform a status effect of the passage of time.
     *
     * @param location the location where the actor with the status effect is currently standing
     * @param actor the actor holding the status effect
     */
    public void tick(Location location, Actor actor) {
        rotCounter -= 1;
        if (rotCounter <= 0) {
            actor.unconscious(location.map());
        }
    }

    public void resetTimer(int count) {
        this.rotCounter = count + 1;
    }
}
