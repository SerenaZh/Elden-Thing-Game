package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.MonologueCapable;

import java.util.List;
import java.util.Random;

/**
 * An action to listen to a monologue from a MonologueCapable NPC.
 */
public class ListenAction extends Action {

    private final MonologueCapable speaker;

    public ListenAction(MonologueCapable speaker) {
        this.speaker = speaker;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        List<String> monologues = speaker.generateMonologuePool(actor, map);
        if (monologues.isEmpty()) {
            return actor + " listens, but hears only silence.";
        }
        String selected = monologues.get(new Random().nextInt(monologues.size()));
        return "\"" + selected + "\"";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + speaker.toString();
    }
}
