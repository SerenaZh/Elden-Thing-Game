package game.factions;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.behaviours.AvoidBehaviour;
import game.items.weapons.WeaponItem;

public class CreatureFaction extends Faction {
    public CreatureFaction() {
        super(Capabilities.CREATURE);
    }

    @Override
    public void factionEffect(WeaponItem weapon) {
        decreaseStanding(1);
    }

    @Override
    public void factionEffect(NonPlayableActor target) {
        if(this.shouldAvoidPlayer()){
             target.addBehaviour(998,new AvoidBehaviour());
            return;
        }
        else if (target.behaviours.containsKey(998)) {
            Behaviour avoidBehaviour = target.behaviours.get(998);
            target.removeBehaviour(998);
        }

    }


    public boolean shouldAvoidPlayer() {
        return this.getStanding() < 2;
    }
}
