package game.actor.npc;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.SelectBehaviour;
import game.behaviours.SelectPriorityBehaviour;

/**
 * <h1>SelectableBehaviourCreature</h1>
 * An abstract base class for non-playable creatures that can use different behaviour selection strategies.
 * <p>
 * This class extends NonPlayableActor and provides the foundation for creatures that can choose
 * their behaviours using either priority-based selection (traditional approach) or random selection
 * (introduced in REQ1). The behaviour selection strategy is determined at instantiation time and
 * cannot be changed during gameplay.
 * </p>
 * <p>
 * Concrete creature classes such as SpiritGoat, OmenSheep, and GoldenBeetle extend this class
 * to inherit the flexible behaviour selection system. This design follows the Strategy Pattern,
 * allowing different instances of the same creature type to exhibit different decision-making
 * patterns.
 * </p>
 *
 * @author Khushi Rajpurohit
 */
public abstract class SelectableBehaviourCreature extends NonPlayableActor {
    /**
     * The strategy used to select which behaviour to execute each turn
     */
    private final SelectBehaviour behaviourSelector;

    /**
     * Constructor for SelectableBehaviourCreature.
     * Creates a creature with the specified attributes and behaviour selection strategy.
     * If no selector is provided, defaults to priority-based behaviour selection.
     *
     * @param name the name of the creature
     * @param displayChar the character used to represent this creature on the map
     * @param hitPoints the creature's health/hit points
     * @param selector the behaviour selection strategy to use, or null to use default priority selection
     */
    public SelectableBehaviourCreature(String name, char displayChar, int hitPoints, SelectBehaviour selector) {
        super(name, displayChar, hitPoints);
        this.behaviourSelector = selector != null ? selector : new SelectPriorityBehaviour();
    }

    /**
     * Determines what action this creature will take on its turn.
     * Uses the assigned behaviour selection strategy to choose from available behaviours.
     * If the creature is unconscious, handles the unconscious state. If no valid behaviour
     * is found, the creature will do nothing for this turn.
     *
     * @param actions the list of actions this creature can potentially perform
     * @param lastAction the action performed in the previous turn
     * @param map the current game map
     * @param display the display object for rendering game information
     * @return the Action to be performed this turn, or DoNothingAction if no valid behaviour is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()) {
            this.unconscious(map);
        }

        Action action = behaviourSelector.selectBehaviour(behaviours, this, map);
        if (action != null) {
            return action;
        }

        return new DoNothingAction();
    }

    /**
     * Returns the behaviour selection strategy used by this creature.
     * This method is protected to allow subclasses to access the selector if needed
     * for specialized behaviour or debugging purposes.
     *
     * @return the SelectBehaviour strategy used by this creature
     */
    protected SelectBehaviour getBehaviourSelector() {
        return behaviourSelector;
    }
}

