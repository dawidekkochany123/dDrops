package dawidos506.ddrops.managers;

import dawidos506.ddrops.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {

    private Main pl = Main.getPlugin(Main.class);

    private File mainFolder;
    private File configFile;
    private File dropsFile;

    private YamlConfiguration configYml;
    private YamlConfiguration dropsYml;

    public FileManager() {
        mainFolder = pl.getDataFolder();
        configFile = new File(mainFolder, "config.yml");
        dropsFile = new File(mainFolder, "drops.yml");
        configYml = YamlConfiguration.loadConfiguration(configFile);
        dropsYml = YamlConfiguration.loadConfiguration(dropsFile);
    }

    public void start() {
        mainFolder = pl.getDataFolder();
        if(!mainFolder.exists()) {
            mainFolder.mkdir();
        }
        configFile = new File(mainFolder, "config.yml");
        if(!configFile.exists()) {
            pl.saveResource("config.yml", true);
        }
        dropsFile = new File(mainFolder, "drops.yml");
        if(!dropsFile.exists()) {
            pl.saveResource("drops.yml", true);
        }
        configYml = YamlConfiguration.loadConfiguration(configFile);
        dropsYml = YamlConfiguration.loadConfiguration(dropsFile);
    }

    public File getMainFolder() {
        return mainFolder;
    }
    public File getConfigFile() {
        return configFile;
    }
    public File getDropsFile() {
        return dropsFile;
    }

    public YamlConfiguration getConfigYml() {
        return configYml;
    }
    public YamlConfiguration getDropsYml() {
        return dropsYml;
    }
}
