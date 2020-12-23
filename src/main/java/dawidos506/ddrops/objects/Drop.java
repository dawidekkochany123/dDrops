package dawidos506.ddrops.objects;

import org.bukkit.inventory.ItemStack;

public class Drop {

    public ItemStack drop;
    public int amount;
    public double chance;

    public Drop(ItemStack drop, int amount, double chance) {
        this.drop = drop;
        this.amount = amount;
        this.chance = chance;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public int getAmount() {
        return amount;
    }

    public double getChance() {
        return chance;
    }
}
