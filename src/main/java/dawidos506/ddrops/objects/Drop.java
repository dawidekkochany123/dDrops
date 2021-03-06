package dawidos506.ddrops.objects;

import org.bukkit.inventory.ItemStack;

public class Drop {

    public ItemStack drop;
    public int id;
    public int amount;
    public double chance;
    public String name;
    public int minY;
    public int maxY;
    public int exp;
    public int dExp;

    public Drop(ItemStack drop, int id, int amount, double chance, String name, int minY, int maxY, int exp, int dExp) {
        this.drop = drop;
        this.id = id;
        this.amount = amount;
        this.chance = chance;
        this.name = name;
        this.minY = minY;
        this.maxY = maxY;
        this.exp = exp;
        this.dExp = dExp;
    }

    public ItemStack getDrop() {
        return drop;
    }
    public int getId() {
        return id;
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
    public int getMinY() {
        return minY;
    }
    public int getMaxY() {
        return maxY;
    }
    public int getExp() {
        return exp;
    }
    public int getdExp() {
        return dExp;
    }
}
