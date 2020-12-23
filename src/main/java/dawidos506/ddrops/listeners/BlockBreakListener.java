package dawidos506.ddrops.listeners;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.managers.DropsManager;
import dawidos506.ddrops.managers.FileManager;
import dawidos506.ddrops.objects.Drop;
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

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();

        if(p.getGameMode().equals(GameMode.SURVIVAL)) {
            if(block.getType().equals(Material.STONE)) {
                double random = ThreadLocalRandom.current().nextDouble(0, 100);
                for(Drop d : pl.getDrops()) {
                    if(block.getY() >= d.getMinY() && block.getY() <= d.getMaxY()) {
                        if(random <= d.getChance()) {
                            ItemStack drop = d.getDrop();
                            drop.setAmount(d.getAmount());
                            p.getWorld().dropItemNaturally(block.getLocation(), drop);
                            p.sendMessage("§4Udalo ci sie wydropic " + d.getName());
                        }
                    }
                }
            }
        }
    }

}
