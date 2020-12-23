package dawidos506.ddrops.managers;

import dawidos506.ddrops.Main;

import java.io.File;

public class FileManager {

    private Main pl = Main.getPlugin(Main.class);

    private File mainFolder;
    private File configFile;
    private File dropsFile;

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

}
