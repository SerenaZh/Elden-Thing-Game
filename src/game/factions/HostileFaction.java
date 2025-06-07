package game.factions;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.behaviours.AvoidBehaviour;
import game.items.weapons.WeaponItem;

public class HostileFaction extends Faction {
    public HostileFaction() {
        super(Capabilities.HOSTILE);
    }

    @Override
    public void factionEffect(WeaponItem weapon) {
        System.out.println("TBD");
    }

    @Override
    public void factionEffect(NonPlayableActor attacker) {
        if(this.shouldAvoid()){
            attacker.addBehaviour(2,new AvoidBehaviour());
        }
        if(attacker.behaviours.containsKey(2) && !this.shouldAvoid()){
            attacker.behaviours.remove(2);
        }
    }

    private boolean shouldAvoid(){
        if(this.getStanding()>8){
            return true;
        }
        return false;
    }
}
