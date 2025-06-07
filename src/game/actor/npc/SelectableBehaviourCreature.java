package game.actor.npc;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.SelectBehaviour;
import game.behaviours.SelectPriorityBehaviour;

public abstract class SelectableBehaviourCreature extends NonPlayableActor {
    private final SelectBehaviour behaviourSelector;

    public SelectableBehaviourCreature(String name, char displayChar, int hitPoints, SelectBehaviour selector) {
        super(name, displayChar, hitPoints);
        this.behaviourSelector = selector != null ? selector : new SelectPriorityBehaviour();
    }

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

    protected SelectBehaviour getBehaviourSelector() {
        return behaviourSelector;
    }
}

