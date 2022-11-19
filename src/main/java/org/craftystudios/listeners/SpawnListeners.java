package org.craftystudios.listeners;

import org.craftystudios.craftycore;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final craftycore plugin;

    public SpawnListeners(craftycore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        if (plugin.getConfig().getBoolean("tpToSpawn") == true) {
            if (!e.getPlayer().hasPlayedBefore()) {
                Location spawn = plugin.getConfig().getLocation("spawn");
                if (spawn != null) {
                    //spawn them
                    e.getPlayer().teleport(spawn);
                    if (!e.getPlayer().hasPlayedBefore()) {
                        Location spawn2 = plugin.getConfig().getLocation("spawn");
                        if (spawn != null) {
                            //spawn them
                            e.getPlayer().teleport(spawn2);


                        } else {
                            Location elseSpawn = e.getPlayer().getWorld().getSpawnLocation();
                            if (spawn != null) {
                                e.getPlayer().teleport(elseSpawn);
                            }
                        }

                    }

                }
            }
        }
    }
}

