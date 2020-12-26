package dawidos506.ddrops.guis;

import dawidos506.ddrops.utils.ChatUtil;
import dawidos506.ddrops.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class GuiAdmin implements Listener {

    private GuiMain guiMain;

    private Inventory eq = Bukkit.createInventory(null, 9, ChatUtil.fixColor("&c&ldDrops&c - Admin Panel"));

    public void openGui(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);

        eq.setItem(4, new ItemBuilder(Material.STICK, 1).setTitle("&bReload").addLore("&7Kliknij, aby przeladowac konfiguracje dropu.").build());
        eq.setItem(8, new ItemBuilder(Material.ARROW, 1).setTitle("&cWroc").addLore("&7Kliknij, aby powrocic do poprzedniego menu.").build());

        p.openInventory(eq);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        guiMain = new GuiMain();
        Player p = (Player)e.getWhoClicked();
        ItemStack is = e.getCurrentItem();

        if(e.getView().getTitle().equals(ChatUtil.fixColor("&c&ldDrops&c - Admin Panel"))) {
            e.setCancelled(true);
            if(is != null) {
                if(e.getSlot() == 4) {
                    p.closeInventory();
                    p.chat("/drop reload");
                }
                else if(e.getSlot() == 8) {
                    guiMain.openGui(p.getUniqueId());
                }
            }
        }
    }

}
