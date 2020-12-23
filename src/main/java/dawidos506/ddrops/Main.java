package dawidos506.ddrops;

import dawidos506.ddrops.listeners.BlockBreakListener;
import dawidos506.ddrops.managers.DropsManager;
import dawidos506.ddrops.managers.FileManager;
import dawidos506.ddrops.objects.Drop;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    private FileManager fileManager;
    private DropsManager dropsManager;

    public List<Drop> drops = new ArrayList<>();

    @Override
    public void onEnable() {
        fileManager = new FileManager();
        dropsManager = new DropsManager();
        new BlockBreakListener();
        fileManager.start();
        dropsManager.load();

        System.out.println("drops:");
        for(Drop d : this.getDrops()) {
            System.out.println(d.getDrop().getType().name());
        }

        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public List<Drop> getDrops() {
        return drops;
    }
}
