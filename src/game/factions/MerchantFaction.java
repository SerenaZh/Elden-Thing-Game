package game.factions;

import edu.monash.fit2099.engine.actors.Actor;
import game.Capabilities;

import java.util.ArrayList;

public class MerchantFaction extends Faction {
    public MerchantFaction(ArrayList<Capabilities> affectionables) {
        super(affectionables);
    }

    @Override
    public void factionEffect(Actor actor) {
        actor.hurt(10);
    }
}
