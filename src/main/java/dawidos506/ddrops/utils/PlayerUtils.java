package dawidos506.ddrops.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class PlayerUtils {

    public static ItemStack getPlayerSkull(UUID uuid) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(Bukkit.getOfflinePlayer(uuid).getName());

        item.setItemMeta(meta);

        return item;
    }

}
