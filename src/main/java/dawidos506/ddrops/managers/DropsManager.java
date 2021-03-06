package dawidos506.ddrops.managers;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.objects.Drop;
import dawidos506.ddrops.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

public class DropsManager {

    private Main pl = Main.getPlugin(Main.class);
    private FileManager fileManager;

    public DropsManager() {
        fileManager = new FileManager();
    }

    public void load() {
        pl.drops.clear();
        YamlConfiguration dropsYml = fileManager.getDropsYml();
        if(dropsYml != null) {
            if(dropsYml.getConfigurationSection("drops") != null) {
                for(String s : dropsYml.getConfigurationSection("drops").getKeys(false)) {
                    Drop drop = new Drop(new ItemBuilder(Material.getMaterial(s), 1).build(), dropsYml.getInt("drops."+s+".id"), dropsYml.getInt("drops." + s + ".amount"), dropsYml.getDouble("drops." + s + ".chance"), dropsYml.getString("drops."+s+".name"), dropsYml.getInt("drops."+s+".minY"), dropsYml.getInt("drops."+s+".maxY"), dropsYml.getInt("drops."+s+".exp"), dropsYml.getInt("drops."+s+".dExp"));
                    pl.drops.add(drop);
                }
            }
        }
    }
}
