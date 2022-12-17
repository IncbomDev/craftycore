package org.craftystudios.commands;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class gm implements CommandExecutor {
    private final JavaPlugin plugin;

    public gm(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public void onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify a gamemode!");
                return;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.GREEN + "Gamemode set to survival!");
                    return;
                }
                if (args[0].equalsIgnoreCase("creative")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.GREEN + "Gamemode set to creative!");
                    return;
                if (args[0].equalsIgnoreCase("adventure")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.GREEN + "Gamemode set to adventure!");
                    return;
                if (args[0].equalsIgnoreCase("spectator")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.GREEN + "Gamemode set to spectator!");
                    return;
                
                }else {
                    player.sendMessage(ChatColor.RED + "Please specify a valid gamemode!");
                    return;
                }
            }
            }
        }
    }
}
    
}
    