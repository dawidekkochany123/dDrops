package dawidos506.ddrops.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ChatUtil {
    public static String fixColor(final String message) {
        return ChatColor.translateAlternateColorCodes('&', message.replace(">>", "»").replace("<<", "«").replace("{CHECK}", "✔").replace("{X}", "✖").replace("{O}", "●"));
    }
    public static List<String> fixColor(final List<String> i) {
        final List<String> output = new ArrayList<String>();
        for (final String l : i) {
            output.add(fixColor(l));
        }
        return output;
    }
}
