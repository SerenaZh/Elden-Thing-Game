package game.actor.npc;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.AttackAction;
import game.actor.Status;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.spi.CalendarDataProvider;

/**
 * A NPC class for any NPCs that are in the game, who cannot be played by the user
 *
 * @authors Serena Zhou & Aryan M
 * Modified by Khushi R
 */
public abstract class NonPlayableActor extends Actor {
    /**
     * For any probabilities in this class
     */
    private final Random rand = new Random();
    /**
     * The map of behaviours that the NonPlayableActor's may have
     */
    public Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Constant for the rank for WanderBehaviour
     */
    public static final int wanderRank=999;

    /**
     * The constructor of the NonPlayableActor class.
     *
     * @param name        the name of the NonPlayableActor
     * @param displayChar the character that will represent the NonPlayableActor in the display
     * @param hitPoints   the NonPlayableActor's starting hit points
     */
    public NonPlayableActor(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(wanderRank, new WanderBehaviour());
    }

    /**
     * Method for returning name of NPC
     *
     * @return String name of NPC
     */
    public String getName() {
        return this.name;
    }

    /**
     * Plays the turn of the NonPlayableActor
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be executed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()) {
            this.unconscious(map);
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
            return new DoNothingAction();
        }

    /**
     * The allowable actions that a NonPlayableActor can be performed on
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return List of all the actions that can be performed on this object Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    public void addBehaviour(int key, Behaviour behaviour){
        this.behaviours.put(key, behaviour);
    }

    public void removeBehaviour(int key){
        this.behaviours.remove(key);
    }
}
