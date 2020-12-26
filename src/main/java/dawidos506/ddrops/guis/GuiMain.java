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

public class GuiMain implements Listener {

    private GuiSettings guiSettings;
    private GuiStats guiStats;
    private GuiRanking guiRanking;
    private GuiAdmin guiAdmin;

    private Inventory eq = Bukkit.createInventory(null, 54, ChatUtil.fixColor("&c&ldDrops&b           by dawidos506"));


    public void openGui(UUID uuid) {
        guiSettings = new GuiSettings();
        Player p = Bukkit.getPlayer(uuid);

        eq.setItem(13, new ItemBuilder(Material.NETHERITE_PICKAXE, 1).setTitle("&b&lStatystyki gracza").addLore("&7Kliknij, aby zobaczyc swoje statystyki.").build());
        eq.setItem(20, new ItemBuilder(Material.DRAGON_HEAD, 1).setTitle("&b&lRanking").addLore("&7Kliknij, aby zobaczyc ranking serwera.").build());
        eq.setItem(24, new ItemBuilder(Material.PAINTING, 1).setTitle("&b&lUstawienia").addLore("&7Kliknij, aby przejsc do ustawien.").build());
        if(p.isOp())
            eq.setItem(40, new ItemBuilder(Material.BARRIER, 1).setTitle("&c&lAdmin Panel").addLore("&7Kliknij, aby przejsc do panelu admina.").build());

        p.openInventory(eq);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        guiSettings = new GuiSettings();
        guiStats = new GuiStats();
        guiRanking = new GuiRanking();
        guiAdmin = new GuiAdmin();
        Player p = (Player)e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack is = e.getCurrentItem();

        if(e.getView().getTitle().equals(ChatUtil.fixColor("&c&ldDrops&b           by dawidos506"))) {
            e.setCancelled(true);
            if(is != null) {
                if(e.getSlot() == 24) {
                    guiSettings.openGui(p.getUniqueId());
                }
                else if(e.getSlot() == 13) {
                    guiStats.openGui(p.getUniqueId());
                }
                else if(e.getSlot() == 20) {
                    guiRanking.openGui(p.getUniqueId());
                }
                else if(e.getSlot() == 40) {
                    guiAdmin.openGui(p.getUniqueId());
                }
            }
        }
    }

}
