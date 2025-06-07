package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SelectRandomBehaviour implements SelectBehaviour {
    private final Random rand = new Random();

    @Override
    public Action selectBehaviour(Map<Integer, Behaviour> behaviours, Actor actor, GameMap map) {
        List<Behaviour> options = new ArrayList<>(behaviours.values());
        if (options.isEmpty()) return null;
        Behaviour chosen = options.get(rand.nextInt(options.size()));
        return chosen.getAction(actor, map);
    }
}
