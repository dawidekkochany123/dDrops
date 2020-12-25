package dawidos506.ddrops.managers;

import dawidos506.ddrops.Main;
import dawidos506.ddrops.objects.User;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.util.UUID;

public class UserManager {

    private Main pl = Main.getPlugin(Main.class);
    private FileManager fileManager;

    public UserManager() {
        fileManager = new FileManager();
    }

    public void load() {
        YamlConfiguration usersYml = fileManager.getUsersYml();
        if(usersYml != null) {
            for(String s : usersYml.getKeys(false)) {
                User user = new User(UUID.fromString(s), usersYml.getString(s+".nick"), usersYml.getInt(s+".mined"), usersYml.getBoolean(s+".msg"), usersYml.getBoolean(s+".cobble"), usersYml.getBoolean(s+".inv"));
                pl.users.add(user);
            }
        }
        else {
            pl.getLogger().info("Nie ma zadnych zarejestrowanych uzytkownikow.");
        }
    }

    public void save() {
        pl.saveResource("users.yml", true);
        YamlConfiguration usersYml = fileManager.getUsersYml();
        for(User u : pl.getUsers()) {
            usersYml.set(u.getUuid()+".nick", u.getNick());
            usersYml.set(u.getUuid()+".mined", u.getMined());
            usersYml.set(u.getUuid()+".msg", u.isMsg());
            usersYml.set(u.getUuid()+".cobble", u.isCobble());
            usersYml.set(u.getUuid()+".inv", u.isInv());
        }
        try {
            usersYml.save(fileManager.getUsersFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void create(UUID uuid) {
        YamlConfiguration usersYml = fileManager.getUsersYml();
        User user = new User(uuid, Bukkit.getOfflinePlayer(uuid).getName(), 0, true, true, false);
        pl.users.add(user);
        save();
    }

    public User get(UUID uuid) {
        for(User u : pl.getUsers()) {
            if(u.getUuid().equals(uuid)) {
                return u;
            }
        }
        return null;
    }

    public boolean exists(UUID uuid) {
        for(User u : pl.getUsers()) {
            if(u.getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

}
