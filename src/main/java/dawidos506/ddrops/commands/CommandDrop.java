package dawidos506.ddrops.commands;

import dawidos506.ddrops.guis.GuiMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDrop implements CommandExecutor {

    private GuiMain guiMain;

    public CommandDrop() {
        guiMain = new GuiMain();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("drop")) {
            if(!(sender instanceof Player)) {

            }
            else {
                Player p = (Player) sender;
                if(!p.isOp() || args.length == 0) {
                    guiMain.openGui(p.getUniqueId());
                }
            }
        }
        return false;
    }


}
