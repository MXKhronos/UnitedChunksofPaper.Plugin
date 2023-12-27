package mx.plugin.unitedchunksofpaper;

import net.kyori.adventure.text.Component;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class UCPMain extends JavaPlugin implements Listener {
    public static JavaPlugin plugin;
    public static Logger logger = null;

    @Override
    public void onEnable() {
        plugin = this;
        logger = this.getLogger();

        Bukkit.getPluginManager().registerEvents(this, this);
        logger.info("Hello Server!");

        new OnlineSleeper();
        CustomRecipesLibrary.LoadRecipes();
    }

    @Override
    public void onDisable() {
        getServer().resetRecipes();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }
    
}