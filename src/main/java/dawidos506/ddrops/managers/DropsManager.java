package dawidos506.ddrops.managers;

import dawidos506.ddrops.objects.Drop;
import dawidos506.ddrops.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

public class DropsManager {

    private FileManager fileManager;

    public List<Drop> drops = new ArrayList<>();

    public DropsManager() {
        fileManager = new FileManager();
        if(fileManager == null) {
            System.out.println("fnull");
        }
    }

    public void load() {
        YamlConfiguration dropsYml = fileManager.getDropsYml();
        if(dropsYml != null) {
            if(dropsYml.getConfigurationSection("drops") != null) {
                for(String s : dropsYml.getConfigurationSection("drops").getKeys(false)) {
                    Drop drop = new Drop(new ItemBuilder(Material.getMaterial(s), 1).build(), dropsYml.getInt("drops." + s + ".amount"), dropsYml.getDouble("drops." + s + ".chance"));
                    drops.add(drop);
                }
            }
        }
        else {
            System.out.println("null");
        }
    }

}
