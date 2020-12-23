package dawidos506.ddrops.listeners;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.managers.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private Main pl = Main.getPlugin(Main.class);
    private UserManager userManager;

    public PlayerJoinListener() {
        userManager = new UserManager();
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(!userManager.exists(p.getUniqueId())) {
            userManager.create(p.getUniqueId());
        }
    }

}
