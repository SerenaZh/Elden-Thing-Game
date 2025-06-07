package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.BuyAction;
import game.actions.ListenAction;
import game.actor.Ability;
import game.behaviours.MonologueCapable;
import game.behaviours.SelectPriorityBehaviour;
import game.items.Buyable;
import game.items.purchaseeffect.AttributeValueChange;
import game.items.purchaseeffect.MaxAttributeChange;
import game.items.purchaseeffect.SpawnActorChange;
import game.items.weapons.Broadsword;
import game.items.weapons.DragonslayerGreatsword;
import game.items.weapons.Katana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing the sorceress Sellen NPC
 * @authors Serena Zhou and Aryan M and Mohammed A
 */
public class SorceressSellen extends NonPlayableActor implements MonologueCapable {
    /**
     * Constructor for SorceressSellen
     */
    public SorceressSellen(){
        super("Sorceress Sellen",'s', 150, new SelectPriorityBehaviour());
        getBuyables();
    }

    /**
     * Method to create items and their customs, and to add them to the merchant's inventory
     * @return List of Buyable objects, objects that can be bought
     */
    private List<Buyable> getBuyables() {
        List<Buyable> buyableList = new ArrayList<>();
        Broadsword broadsword = new Broadsword(100);
        broadsword.addEffect(new MaxAttributeChange(20, BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE));

        DragonslayerGreatsword greatsword = new DragonslayerGreatsword(1500);
        greatsword.addEffect(new SpawnActorChange(new GoldenBeetle()));

        Katana katana = new Katana(500);
        katana.addEffect(new AttributeValueChange(10, BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE));
        katana.addEffect(new MaxAttributeChange(20, BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE));
        SpawnActorChange spawnChange = new SpawnActorChange(new OmenSheep());
        spawnChange.addSpawnTarget(this);
        katana.addEffect(spawnChange);

        buyableList.add(broadsword);
        buyableList.add(greatsword);
        buyableList.add(katana);
        return  buyableList;
    }

    /**
     * Returns the list of available monologue lines.
     * @param listener The actor listening (usually the player)
     * @param map The game map
     * @return List of valid monologue lines
     */
    @Override
    public List<String> generateMonologuePool(Actor listener, GameMap map) {
        return Arrays.asList(
                "The academy casts out those it fears. Yet knowledge, like the stars, cannot be bound forever.",
                "You sense it too, don’t you? The Glintstone hums, even now."
        );
    }

    /**
     * Allowable actions that another Actor can do to this Actor
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList a list of actions that can be done
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = super.allowableActions(otherActor, direction, map);
        for (Buyable buyable: this.getBuyables()) {
            actionList.add(new BuyAction(buyable));
        }
        actionList.add(new ListenAction(this));

        return actionList;
    }
}
