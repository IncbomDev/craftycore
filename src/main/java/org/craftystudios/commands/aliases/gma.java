package org.craftystudios.commands.aliases;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class gma implements CommandExecutor {
    private final JavaPlugin plugin;

    public gma(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public void onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(ChatColor.GREEN + "Gamemode set to adventure!");
            

            
            }
        }
           
    
}
    