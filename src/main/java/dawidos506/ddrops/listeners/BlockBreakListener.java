package dawidos506.ddrops.listeners;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.managers.DropsManager;
import dawidos506.ddrops.managers.FileManager;
import dawidos506.ddrops.managers.UserManager;
import dawidos506.ddrops.objects.Drop;
import dawidos506.ddrops.objects.User;
import dawidos506.ddrops.utils.ChatUtil;
import dawidos506.ddrops.utils.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockBreakListener implements Listener {

    private Main pl = Main.getPlugin(Main.class);
    private UserManager userManager;

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        userManager = new UserManager();
        Player p = e.getPlayer();
        Block block = e.getBlock();
        User user = userManager.get(p.getUniqueId());

        if(p.getGameMode().equals(GameMode.SURVIVAL)) {
            if(block.getType().equals(Material.STONE)) {
                double random = ThreadLocalRandom.current().nextDouble(0, 100);
                userManager.addMined(p.getUniqueId());


                if(!user.isCobble()) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                }
                else if(user.isCobble() && user.isInv()) {
                    e.setCancelled(true);
                    block.setType(Material.AIR);
                    p.getInventory().addItem(new ItemBuilder(Material.COBBLESTONE, 1).build());
                }


                for(Drop d : pl.getDrops()) {
                    if(block.getY() >= d.getMinY() && block.getY() <= d.getMaxY()) {
                        if(random <= d.getChance()) {
                            ItemStack drop = d.getDrop();
                            drop.setAmount(d.getAmount());
                            if(user.isInv()) {
                                p.getInventory().addItem(drop);
                            }
                            else {
                                p.getWorld().dropItemNaturally(block.getLocation(), drop);
                            }
                            if(user.isMsg()) {
                                p.sendMessage(ChatUtil.fixColor("&bUdalo ci sie wydropic " + d.getName() + "&b!"));
                            }
                            p.giveExp(d.getExp());
                            userManager.addExp(p.getUniqueId(), d.getdExp());
                        }
                    }
                }
            }
        }
    }

}
