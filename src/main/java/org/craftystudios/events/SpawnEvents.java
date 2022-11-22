package org.craftystudios.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.craftystudios.CraftyCore;

public class SpawnEvents extends  JavaPlugin {


    private final CraftyCore plugin;

    public SpawnEvents(CraftyCore plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public boolean onPlayerJoin(PlayerJoinEvent e){
        if(getConfig().getBoolean("tpToSpawn") ==true ) {
            Location spawn = (Location) getConfig().get("spawn");
            if(spawn != null) {
                Player p = e.getPlayer();
                p.teleport(spawn);
            }else if(getConfig().getBoolean("tpToSpawn") == false) {
                return false;

            }
        }
        Player p = e.getPlayer();


        //When a player joins for the first time, teleport them to the spawn if it is set
        if(!e.getPlayer().hasPlayedBefore()){
            Location spawn = (Location) getConfig().get("spawn");

            if(spawn != null){
                e.getPlayer().teleport(spawn);
            }
        }

        return false;
    }

    @EventHandler
    public boolean onPlayerDeath(PlayerRespawnEvent e){
        if(getConfig().getBoolean("deathSpawn") == true){
            Location spawn = (Location) getConfig().get("spawn");

            if(spawn != null){
                e.setRespawnLocation(spawn);
                return true;

            }
        }else if(getConfig().getBoolean("deathSpawn") == false){

            return false;


        }
        return false;
    }

}