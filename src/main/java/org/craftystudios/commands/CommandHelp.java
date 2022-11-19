package org.craftystudios.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class CommandHelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("§6§lCraftyStudios §7§l» §f§lCommands:");
            player.sendMessage("§6§lCraftyStudios §7§l» §f§l/craftycore §7§l- §f§lShows the plugin info.");
            player.sendMessage("§6§lCraftyStudios §7§l» §f§l/craftycore help §7§l- §f§lShows the help gui.");
            player.sendMessage("§6§lCraftyStudios §7§l» §f§l/craftycore reload §7§l- §f§lReloads the plugin.");
            player.sendMessage("§6§lCraftyStudios §7§l» §f§l/craftycore update §7§l- §f§lChecks for updates.");


            // If the player (or console) uses our command correct, we can return true
            return true;
        }
        return false;
    }
}