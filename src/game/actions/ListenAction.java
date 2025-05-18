package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.MonologueCapable;

import java.util.List;
import java.util.Random;

/**
 * An action to listen to a monologue from a MonologueCapable NPC.
 *
 * @author Mohammed A
 */
public class ListenAction extends Action {
    /**
     * The speaker that is able to talke
     */
    private final MonologueCapable speaker;

    /**
     * Constructor for ListenAction
     * @param speaker
     */
    public ListenAction(MonologueCapable speaker) {
        this.speaker = speaker;
    }

    /**
     * Executes the listening for the player
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string of what they listened to or nothing
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<String> monologues = speaker.generateMonologuePool(actor, map);
        if (monologues.isEmpty()) {
            return actor + " listens, but hears only silence.";
        }
        String selected = monologues.get(new Random().nextInt(monologues.size()));
        return "\"" + selected + "\"";
    }

    /**
     * Shows the text option to be displayed on the terminal
     * @param actor The actor performing the action.
     * @return String to be printed
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + speaker.toString();
    }
}
