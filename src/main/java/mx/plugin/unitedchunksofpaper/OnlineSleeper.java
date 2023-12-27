package mx.plugin.unitedchunksofpaper;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class OnlineSleeper implements Listener {
    public static ArrayList<Player> sleepingPlayers = new ArrayList<>();
    boolean speedSpeeding = false;

    public OnlineSleeper() {
        Bukkit.getPluginManager().registerEvents(this, UCPMain.plugin);
        UCPMain.logger.info("Loaded online sleeper.");
    }

    public boolean IsDay() {
        long time = UCPMain.plugin.getServer().getWorld("world").getTime();
        return time < 12300 || time > 23850;
    }

    @EventHandler
    public void OnPlayerBedEnterEvent(PlayerBedEnterEvent event) {
        if (!event.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK)) return;

        Player player = event.getPlayer();
        sleepingPlayers.add(player);

        if (!speedSpeeding) {
            speedSpeeding = true;

            new BukkitRunnable() {
                @Override
                public void run() {
                    int sleepers = sleepingPlayers.size();
                    World currentWorld = event.getBed().getWorld();
                    currentWorld.setTime(currentWorld.getTime() + (40 * sleepers/Bukkit.getOnlinePlayers().size()));

                    if (sleepers <= 0 || IsDay()) {
                        cancel();
                        if (IsDay()) {
                            currentWorld.setStorm(false);
                            currentWorld.setThundering(false);
                        }
                        speedSpeeding = false;
                    }
                }
            }.runTaskTimer(UCPMain.plugin, 0, 1);
        }
    }

    @EventHandler
    public void OnPlayerBedExitEvent(PlayerBedLeaveEvent event) {
        sleepingPlayers.remove(event.getPlayer());
    }
}
