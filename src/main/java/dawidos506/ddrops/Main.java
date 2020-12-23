package dawidos506.ddrops;

import dawidos506.ddrops.managers.DropsManager;
import dawidos506.ddrops.managers.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private FileManager fileManager;
    private DropsManager dropsManager;

    @Override
    public void onEnable() {
        fileManager = new FileManager();
        dropsManager = new DropsManager();
        fileManager.start();
        dropsManager.load();
    }

    @Override
    public void onDisable() {

    }
}
