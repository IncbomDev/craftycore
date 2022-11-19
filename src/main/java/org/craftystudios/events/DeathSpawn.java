package org.craftystudios.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.craftystudios.craftycore;
import org.craftystudios.utils.Logger;
import org.craftystudios.utils.Settings;

public class DeathSpawn {
    private final craftycore plugin;

    public DeathSpawn(craftycore plugin) {
        this.plugin = plugin;
    }

    public void onPlayerDeath(PlayerDeathEvent event) {
        if (plugin.getConfig().getBoolean("deathSpawn") == true) {
            Player player = event.getEntity();
            Location spawn = plugin.getConfig().getLocation("spawn");
            if (spawn != null) {
                Location fallbackSpawn = player.getPlayer().getWorld().getSpawnLocation();
                if (spawn != null) {
                    player.getPlayer().teleport(fallbackSpawn);
                    player.getPlayer().teleport(spawn);
                    Logger.log(Logger.LogLevel.OUTLINE, "***********************************************************");
                    Logger.log(Logger.LogLevel.WARNING, ("WARNING! SPAWN IS NOT SET"));
                    Logger.log(Logger.LogLevel.WARNING, ("PLAYERS WILL BE GLITCHED WHEN SPAWNING IN WITH  "));
                    Logger.log(Logger.LogLevel.WARNING, ("deathSpawn AND tpOnJoin ENABLED"));
                    Logger.log(Logger.LogLevel.WARNING, ("PLEASE SET SPAWN IN CONFIG"));
                    Logger.log(Logger.LogLevel.OUTLINE, "***********************************************************");
                }
            }
        }
    }
}