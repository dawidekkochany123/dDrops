package dawidos506.ddrops.objects;

import org.bukkit.inventory.ItemStack;

public class Drop {

    public ItemStack drop;
    public int amount;
    public double chance;
    public String name;

    public Drop(ItemStack drop, int amount, double chance, String name) {
        this.drop = drop;
        this.amount = amount;
        this.chance = chance;
        this.name = name;
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

    public String getName() {
        return name;
    }
}
