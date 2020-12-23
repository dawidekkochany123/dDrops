package dawidos506.ddrops;

import dawidos506.ddrops.listeners.BlockBreakListener;
import dawidos506.ddrops.listeners.PlayerJoinListener;
import dawidos506.ddrops.managers.DropsManager;
import dawidos506.ddrops.managers.FileManager;
import dawidos506.ddrops.managers.UserManager;
import dawidos506.ddrops.objects.Drop;
import dawidos506.ddrops.objects.User;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    private FileManager fileManager;
    private DropsManager dropsManager;
    private UserManager userManager;

    public List<Drop> drops = new ArrayList<>();
    public List<User> users = new ArrayList<>();

    @Override
    public void onEnable() {
        fileManager = new FileManager();
        dropsManager = new DropsManager();
        userManager = new UserManager();

        new BlockBreakListener();
        fileManager.start();
        dropsManager.load();
        userManager.load();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {}

    public List<Drop> getDrops() {
        return drops;
    }
    public List<User> getUsers() {
        return users;
    }
}
