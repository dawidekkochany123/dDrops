package dawidos506.ddrops.guis;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.managers.UserManager;
import dawidos506.ddrops.objects.User;
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

public class GuiRanking implements Listener {

    private Main pl = Main.getPlugin(Main.class);
    private UserManager userManager;
    private GuiMain guiMain;
    private GuiRankingMined guiRankingMined;
    private GuiRankingLevel guiRankingLevel;

    private Inventory eq = Bukkit.createInventory(null, 9, ChatUtil.fixColor("&c&ldDrops&c - Ranking"));

    public void openGui(UUID uuid) {
        userManager = new UserManager();
        Player p = Bukkit.getPlayer(uuid);
        User user = userManager.get(uuid);

        eq.setItem(3, new ItemBuilder(Material.WOODEN_PICKAXE, 1).setTitle("&bNajwiecej wykopanego kamienia").addLore("&7Kliknij, aby zobaczyc ranking.").build());
        eq.setItem(5, new ItemBuilder(Material.EXPERIENCE_BOTTLE, 1).setTitle("&bNajwiekszy poziom").addLore("&7Kliknij, aby zobaczyc ranking.").build());
        eq.setItem(8, new ItemBuilder(Material.ARROW, 1).setTitle("&cWroc").addLore("&7Kliknij, aby powrocic do poprzedniego menu.").build());

        p.openInventory(eq);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        guiMain = new GuiMain();
        guiRankingMined = new GuiRankingMined();
        guiRankingLevel = new GuiRankingLevel();
        Player p = (Player)e.getWhoClicked();
        ItemStack is = e.getCurrentItem();

        if(e.getView().getTitle().equals(ChatUtil.fixColor("&c&ldDrops&c - Ranking"))) {
            e.setCancelled(true);
            if(is != null) {
                if(e.getSlot() == 3) {
                    guiRankingMined.openGui(p.getUniqueId());
                }
                else if(e.getSlot() == 5) {
                    guiRankingLevel.openGui(p.getUniqueId());
                }
                else if(e.getSlot() == 8) {
                    guiMain.openGui(p.getUniqueId());
                }
            }
        }
    }

}
