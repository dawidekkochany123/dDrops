package dawidos506.ddrops.guis;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.managers.UserManager;
import dawidos506.ddrops.objects.Drop;
import dawidos506.ddrops.objects.User;
import dawidos506.ddrops.utils.ChatUtil;
import dawidos506.ddrops.utils.ItemBuilder;
import dawidos506.ddrops.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuiSettings implements Listener {

    private Main pl = Main.getPlugin(Main.class);
    private UserManager userManager;

    private Inventory eq = Bukkit.createInventory(null, 54, ChatUtil.fixColor("&c&ldDrops&c - Ustawienia"));

    public void openGui(UUID uuid) {
        userManager = new UserManager();
        Player p = Bukkit.getPlayer(uuid);
        User user = userManager.get(uuid);

        int temp = 0;
        for(Drop d : pl.getDrops()) {
            ItemStack drop = d.getDrop();
            ItemMeta im = drop.getItemMeta();
            im.setDisplayName(ChatUtil.fixColor(d.getName()));
            List<String> lore = new ArrayList<>(); {
                lore.add(ChatUtil.fixColor("&7Ilosc: &b" + d.getAmount()));
                lore.add(ChatUtil.fixColor("&7Szansa: &b" + d.getChance()));
                lore.add(ChatUtil.fixColor("&7Min Y: &b" + d.getMinY()));
                lore.add(ChatUtil.fixColor("&7Max Y: &b" + d.getMaxY()));
            }
            im.setLore(lore);
            drop.setItemMeta(im);
            eq.setItem(temp, drop);
            temp++;
        }

        ItemStack playerHead = PlayerUtils.getPlayerSkull(uuid); {
            ItemMeta im = playerHead.getItemMeta();
            im.setDisplayName(ChatUtil.fixColor("&bPrzedmioty trafiaja do ekwipunku"));
            List<String> lore = new ArrayList<>();
            if(user.isInv())
                lore.add(ChatUtil.fixColor("&7Wlaczone: &aTAK"));
            else
                lore.add(ChatUtil.fixColor("&7Wlaczone: &cNIE"));
            im.setLore(lore);
            playerHead.setItemMeta(im);
        }
        ItemStack cobble = new ItemBuilder(Material.COBBLESTONE, 1).setTitle("&bDrop cobblestone").build(); {
            ItemMeta im = cobble.getItemMeta();
            List<String> lore = new ArrayList<>();
            if(user.isCobble())
                lore.add(ChatUtil.fixColor("&7Wlaczone: &aTAK"));
            else
                lore.add(ChatUtil.fixColor("&7Wlaczone: &cNIE"));
            im.setLore(lore);
            cobble.setItemMeta(im);
        }
        ItemStack msg = new ItemBuilder(Material.OAK_SIGN, 1).setTitle("&bWiadomosci").build(); {
            ItemMeta im = msg.getItemMeta();
            List<String> lore = new ArrayList<>();
            if(user.isMsg())
                lore.add(ChatUtil.fixColor("&7Wlaczone: &aTAK"));
            else
                lore.add(ChatUtil.fixColor("&7Wlaczone: &cNIE"));
            im.setLore(lore);
            msg.setItemMeta(im);
        }

        eq.setItem(48, playerHead);
        eq.setItem(49, cobble);
        eq.setItem(50, msg);

        p.openInventory(eq);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        userManager = new UserManager();

        Player p = (Player)e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack is = e.getCurrentItem();
        User user = userManager.get(p.getUniqueId());

        if(e.getView().getTitle().equals(ChatUtil.fixColor("§c&ldDrops&c - Ustawienia"))) {
            e.setCancelled(true);
            if(is != null) {
                if(is.getType().equals(Material.PLAYER_HEAD)) {
                    user.setInv(!user.isInv());
                    openGui(p.getUniqueId());
                }
                else if(is.getType().equals(Material.COBBLESTONE)) {
                    user.setCobble(!user.isCobble());
                    openGui(p.getUniqueId());
                }
                else if(is.getType().equals(Material.OAK_SIGN)) {
                    user.setMsg(!user.isMsg());
                    openGui(p.getUniqueId());
                }
            }
        }
    }

}
