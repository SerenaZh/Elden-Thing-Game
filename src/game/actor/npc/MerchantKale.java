package game.actor.npc;

import game.items.weapons.Broadsword;

public class MerchantKale extends NonPlayableActor {
    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
        this.addItemToInventory(new Broadsword());
    }
}
