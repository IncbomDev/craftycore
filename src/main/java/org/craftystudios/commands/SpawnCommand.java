package org.craftystudios.commands;

import org.craftystudios.craftycore;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final craftycore plugin;

    public SpawnCommand(craftycore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Make sure that they are a player
        if (sender instanceof Player){

            Player player = (Player) sender;

            //see if the plugin has a spawn point set in the config
            Location location = plugin.getConfig().getLocation("spawn");
            if (location != null){

                //teleport the player to the spawn point
                player.teleport(location);

                //send a message to the player
                for(String spawnMessage : plugin.getConfig().getStringList("spawnMessage")){
                    player.sendMessage(spawnMessage);
                }

            }else{
                for(String noSpawnSet : plugin.getConfig().getStringList("noSpawnSet")){
                    player.sendMessage(noSpawnSet);
                }


            }

        }else{
            System.out.println("wat");
        }

        return true;
    }
}