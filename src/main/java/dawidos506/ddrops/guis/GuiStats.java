package dawidos506.ddrops.guis;

import dawidos506.ddrops.managers.UserManager;
import dawidos506.ddrops.objects.User;
import dawidos506.ddrops.utils.ChatUtil;
import dawidos506.ddrops.utils.ItemBuilder;
import dawidos506.ddrops.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuiStats implements Listener {

    private UserManager userManager;

    private Inventory eq = Bukkit.createInventory(null, 54, ChatUtil.fixColor("&c&ldDrops&c - Statystyki"));

    public void openGui(UUID uuid) {
        userManager = new UserManager();
        Player p = Bukkit.getPlayer(uuid);
        User user = userManager.get(uuid);

        ItemStack playerHead = PlayerUtils.getPlayerSkull(uuid); {
            ItemMeta im = playerHead.getItemMeta();
            im.setDisplayName(ChatUtil.fixColor("&b" + p.getName()));
            playerHead.setItemMeta(im);
        }

        eq.setItem(13, playerHead);
        eq.setItem(30, new ItemBuilder(Material.NETHERITE_PICKAXE, 1).setTitle("&bIlosc wykopanego kamienia").addLore("&7Wykopany kamien: &b" + user.getMined()).build());
        eq.setItem(32, new ItemBuilder(Material.EXPERIENCE_BOTTLE, 1).setTitle("&bPoziom gracza").addLore("&7Poziom: &b" + user.getLevel()).addLore("&7Doswiadczenie: &b" + user.getExperience()).build());

        p.openInventory(eq);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equals(ChatUtil.fixColor("&c&ldDrops&c - Statystyki"))) {
            e.setCancelled(true);
        }
    }

}
