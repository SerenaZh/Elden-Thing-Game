package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Curable;

/**
 * Class representing an action to cure
 * This class will only cure things that
 * are implemented with Curable AKA only things
 * that can be cured
 * @author Serena Zhou
 */
public class CureAction extends Action {
    /**
     * Thing curable thing that is to be cured
     */
    private Curable curable;

    /**
     * Constructor
     * @param curable the Curable to be cured
     */
    public CureAction (Curable curable){
        this.curable = curable;
    }

    /**
     * Executes curing the Curable by an Actor
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String to be printed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (curable.cure(actor, map)) {
            return actor.toString() + " has cured " + curable.toString();
        }
        return actor.toString() + " has ran out out stamina to cure " + curable.toString();
    }

    /**
     * Shows the text option to be displayed on the terminal
     * @param actor The actor performing the action.
     * @return String to be printed
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " cures " + curable.toString();
    }
}
