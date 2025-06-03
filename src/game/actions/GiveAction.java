package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.factions.Faction;
import game.factions.FactionStandingManager;


/**
 *
 */

public class GiveAction extends Action {
    private Item item;
    private Actor target;
    public GiveAction(Actor target, Item item) {
        this.item = item;
        this.target = target;
    }

    /**
     * Constructor
     * @param actor that is buying the buyable
     * @param map map player is.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this.item);
        this.target.addItemToInventory(this.item);

        Faction faction = FactionStandingManager.allFactions.get(Capabilities.MERCHANT);
        faction.increaseStanding(1);

        return "Farmer gave "+this.item.toString()+" to "+this.target.toString()+", you standing is as follows: "+faction;
    }

    /**
     * Shows the text option to be displayed on the terminal
     * @param actor The actor performing the action.
     * @return String to be printed
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Give " + this.item.toString() + " to " + this.target.toString();
    }
}