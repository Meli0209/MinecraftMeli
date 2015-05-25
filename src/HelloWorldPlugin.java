/**
 * Created by Meli on 25.05.2015.
 */
public class HelloWorldPlugin {
}
import java.util.logging.Logger;

        import org.bukkit.command.Command;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import org.bukkit.plugin.java.JavaPlugin;

public class HelloWorldPlugin extends JavaPlugin {
    public static Logger log =Logger.getLogger("Minecraft");

    public void onLoad() {

        log.info("[HelloWorldPlugin] Loaded...");

    }
    public void onEnable() {

        log.info("[HelloWorldPlugin] Starting up...");

    }
    public void onDisable() {

        log.info("[HelloWorldPlugin] Shuting down...");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("Helloworld")) {

            if (sender instanceof Player){
                String message = "[Server]: Hallo Fotzis <3";
                getServer().broadcastMessage(message);
                return true;
            } else {
                sender.sendMessage("[Server]:Fotze!");
            }



        } else if (command.getName().equalsIgnoreCase("kill")){
            Player opfer = sender.getServer().getPlayer(args[0])
            if ()
        }

    }