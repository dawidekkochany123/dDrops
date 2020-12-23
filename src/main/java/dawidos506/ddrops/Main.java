package dawidos506.ddrops;

import dawidos506.ddrops.managers.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private FileManager fileManager;

    @Override
    public void onEnable() {
        fileManager = new FileManager();
        fileManager.start();
    }

    @Override
    public void onDisable() {

    }
}
