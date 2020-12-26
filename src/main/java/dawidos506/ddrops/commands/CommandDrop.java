package dawidos506.ddrops.commands;

import dawidos506.ddrops.guis.GuiMain;
import dawidos506.ddrops.managers.DropsManager;
import dawidos506.ddrops.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDrop implements CommandExecutor {

    private GuiMain guiMain;
    private DropsManager dropsManager;

    public CommandDrop() {
        guiMain = new GuiMain();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        dropsManager = new DropsManager();
        if(command.getName().equalsIgnoreCase("drop")) {
            if(!(sender instanceof Player)) {

            }
            else {
                Player p = (Player) sender;
                if(!p.isOp() || args.length == 0) {
                    guiMain.openGui(p.getUniqueId());
                }
                else {
                    if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
                            dropsManager.load();
                            p.sendMessage(ChatUtil.fixColor("&7Konfiguracja dropow przeladowana."));
                        }
                    }
                }
            }
        }
        return false;
    }


}
