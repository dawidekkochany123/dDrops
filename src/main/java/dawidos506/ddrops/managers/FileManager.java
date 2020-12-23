package dawidos506.ddrops.managers;

import dawidos506.ddrops.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {

    private Main pl = Main.getPlugin(Main.class);

    private File mainFolder;
    private File configFile;
    private File dropsFile;
    private File usersFile;

    private YamlConfiguration configYml;
    private YamlConfiguration dropsYml;
    private YamlConfiguration usersYml;

    public FileManager() {
        mainFolder = pl.getDataFolder();
        configFile = new File(mainFolder, "config.yml");
        dropsFile = new File(mainFolder, "drops.yml");
        usersFile = new File(mainFolder, "users.yml");
        configYml = YamlConfiguration.loadConfiguration(configFile);
        dropsYml = YamlConfiguration.loadConfiguration(dropsFile);
        usersYml = YamlConfiguration.loadConfiguration(usersFile);
    }

    public void start() {
        if(!mainFolder.exists()) {
            mainFolder.mkdir();
        }
        if(!configFile.exists()) {
            pl.saveResource("config.yml", true);
        }
        if(!dropsFile.exists()) {
            pl.saveResource("drops.yml", true);
        }
        if(!usersFile.exists()) {
            pl.saveResource("users.yml", true);
        }
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
    public File getUsersFile() {
        return usersFile;
    }

    public YamlConfiguration getConfigYml() {
        return configYml;
    }
    public YamlConfiguration getDropsYml() {
        return dropsYml;
    }
    public YamlConfiguration getUsersYml() {
        return usersYml;
    }

}
