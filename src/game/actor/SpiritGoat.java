package game.actor;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.Curable;
import game.actions.CureAction;

/**
 * Class representing the Spirit Goat that roams the land
 * Spirit Goat is a NonPlayableActor
 * @author Serena Zhou
 */
public class SpiritGoat extends NonPlayableActor implements Curable {
//    /**
//     * Countdown timer for when the Actor rots
//     */
//    private int rotTimer;
    private RotEffect rotEffect = new RotEffect(10);

    /**
     * Constructor for the Spirit Goat
     */
    public SpiritGoat() {
        super("Spirit Goat", 'y', 50 );
//        this.rotTimer = 10;
        this.addStatusEffect(rotEffect);
        this.addCapability(Capabilities.CURABLE);
    }
//
//    /**
//     * Counts down the rot countdown timer
//     */
//    public void decreaseRotTimer(){
//        rotTimer --;
//    }
//
//    /**
//     * Getter for the countdown time left
//     * @return int of how many turns left until Sheep disappears
//     */
//    public int getRotTimer() {
//        return rotTimer;
//    }
//
//    /**
//     * Resets the countdown timer for the rot
//     */
//    public void resetRotTimer() {
//        this.rotTimer = 10;
//    }

    /**
     * Cures the Spirit Goat
     * @param actor that is curing the goat
     * @param map of the Game
     * @return boolean if the goat can be cured
     */
    @Override
    public boolean cure(Actor actor, GameMap map) {
        this.rotEffect.resetTimer(10);
//        this.resetRotTimer();
        return true;
    }

//    /**
//     * Plays the turn of the SpiritGoat
//     * @param actions    collection of possible Actions for this Actor
//     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
//     * @param map        the map containing the Actor
//     * @param display    the I/O object to which messages may be written
//     * @return the Action to be executed
//     */
//    @Override
//    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
//        decreaseRotTimer();
//        if (getRotTimer() <= 0) {
//            this.unconscious(map);
//            return new DoNothingAction();
//        }
//
//        return super.playTurn(actions, lastAction, map, display);
//    }

    /**
     * Gets the allowable actions that can be done to this Actor
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of Action objects that can be done to the Omen Sheep
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Capabilities.CURABLE)) {
            actions.add(new CureAction(this));
        }
        return actions;
    }
}
