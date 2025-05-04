package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class representing a wall that cannot be entered by any actor
 * @author Riordan D. Alfredo
 * modified by Serena Zhou
 */
public class Wall extends Ground {
    /**
     * Constructor for Wall
     */
    public Wall() {
        super('#', "Wall");
    }

    /**
     * If the actor can go into the tile where this wall is
     * @param actor the Actor to check
     * @return boolean if they can enter or not
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
