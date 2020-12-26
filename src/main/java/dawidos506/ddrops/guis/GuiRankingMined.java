package dawidos506.ddrops.guis;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.managers.UserManager;
import dawidos506.ddrops.objects.User;
import dawidos506.ddrops.utils.ChatUtil;
import dawidos506.ddrops.utils.ItemBuilder;
import dawidos506.ddrops.utils.MapUtil;
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

import java.util.*;
import java.util.stream.Collectors;

public class GuiRankingMined implements Listener {

    private Main pl = Main.getPlugin(Main.class);
    private UserManager userManager;
    private GuiRanking guiRanking;

    private Inventory eq = Bukkit.createInventory(null, 9, ChatUtil.fixColor("&c&ldDrops&c - Ranking (Wykopane bloki)"));

    public void openGui(UUID uuid) {
        userManager = new UserManager();
        Player p = Bukkit.getPlayer(uuid);
        User user = userManager.get(uuid);

        for(int i = 2; i < 7; i++) {
            int place = i-1;
            eq.setItem(i, new ItemBuilder(Material.PLAYER_HEAD, 1).setTitle("&c&l" + place + ".&b BRAK").build());
        }

        Map<String, Integer> unsorted = new HashMap<>(); {
            for(User u : pl.getUsers()) {
                unsorted.put(u.getNick(), u.getMined());
            }
        }
        Map<String, Integer> sorted = MapUtil.sortByValue(unsorted);
        int slot = 2;
        int place = 1;
        for(String s : sorted.keySet()) {
            ItemStack p1 = PlayerUtils.getPlayerSkull(Bukkit.getOfflinePlayer(s).getUniqueId()); {
                ItemMeta im = p1.getItemMeta();
                im.setDisplayName(ChatUtil.fixColor("&c&l" + place + ".&b " + s));
                List<String> lore = new ArrayList<>(); {
                    lore.add(ChatUtil.fixColor("&7Wykopane bloki: &b" + sorted.get(s)));
                }
                im.setLore(lore);
                p1.setItemMeta(im);
            }
            eq.setItem(slot, p1);
            slot++;
            place++;
            if(slot == 7) {
                break;
            }
        }

        eq.setItem(8, new ItemBuilder(Material.ARROW, 1).setTitle("&cWroc").addLore("&7Kliknij, aby powrocic do poprzedniego menu.").build());

        p.openInventory(eq);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        guiRanking = new GuiRanking();
        Player p = (Player)e.getWhoClicked();
        if(e.getView().getTitle().equals(ChatUtil.fixColor("&c&ldDrops&c - Ranking (Wykopane bloki)"))) {
            e.setCancelled(true);
            if(e.getSlot() == 8) {
                guiRanking.openGui(p.getUniqueId());
            }
        }
    }

}
