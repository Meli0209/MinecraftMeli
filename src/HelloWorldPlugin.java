/**
 * Created by Meli on 25.05.2015.
 */
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.util.BlockIterator;
import com.sun.javafx.scene.EnteredExitedHandler;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloWorldPlugin extends JavaPlugin {
    public static Logger log = Logger.getLogger("Minecraft");

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
        if (command.getName().equalsIgnoreCase("HelloWorld")) {

            if (sender instanceof Player) {
                String message = "[Server]: Hallo <3";
                getServer().broadcastMessage(message);
                return true;
            } else {
                sender.sendMessage("[Server]:Fotze!");
            }


        } else if (command.getName().equalsIgnoreCase("killplayer")) {
            Player opfer = sender.getServer().getPlayer(args[0]);
            if (opfer == null) {
                sender.sendMessage("Player" + args[0] + "is not online!");
                return true;
            }
            opfer.getWorld().createExplosion(opfer.getLocation(), 12);
            opfer.setHealth(0.0);
        }
        else if (command.getName().equalsIgnoreCase("up")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                List<Entity> list = me.getNearbyEntities(20.0, 20.0, 20.0);
                for (Entity target: list){
                    Vector v = new Vector(0,10,0);
                    target.setVelocity(v);
                }
            }
        }
        else if (command.getName().equalsIgnoreCase("flyingcreeper")){

            // spawn bat, spawn creeper, set creeper as passanger of bet

        }

        return false;
    }

    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (p.getItemInHand().getType() == Material.SEEDS) {

            Location loc = p.getTargetBlock((Set<Material>) null, 200).getLocation();
            p.getWorld().strikeLightning(loc);


        }
        else if (p.getItemInHand().getType() == Material.DIRT) {
            BlockIterator blocks = new BlockIterator(p,500);
            while (blocks.hasNext()){
                Block b = blocks.next();

                if (b.getType() != Material.AIR) {
                    if (b.getType() != Material.DIAMOND_BLOCK
                            && b.getType() != Material.GOLD_ORE
                            && b.getType() != Material.IRON_ORE
                            && b.getType() != Material.REDSTONE_ORE
                            && b.getType() != Material.COAL_ORE
                            && b.getType() != Material.LAPIS_ORE) {
                        b.setType(Material.AIR);
                        p.playSound(b.getLocation(), Sound.CAT_MEOW, 1.0f, 5.0f);
                    }
                }
            }

        }

        //create block iterator
    }
}