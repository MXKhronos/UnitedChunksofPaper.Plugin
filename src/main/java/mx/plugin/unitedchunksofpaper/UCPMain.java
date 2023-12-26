package mx.plugin.unitedchunksofpaper;

import net.kyori.adventure.text.Component;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class UCPMain extends JavaPlugin implements Listener {
    public Logger logger = null;

    @Override
    public void onEnable() {
        logger = this.getLogger();

        Bukkit.getPluginManager().registerEvents(this, this);
        logger.info("Hello Server!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }
    
}