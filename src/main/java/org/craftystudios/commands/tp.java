package org.craftystudios.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class tp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                for (String tpPlayerNotFound : plugin.getConfig().getStringList("tpPlayerNotFound")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + tpPlayerNotFound));
                }
                for (String tpPlayerNotFound : plugin.getConfig().getStringList("tpPlayerNotFound")) {
                    player.sendMessage(plugin.getConfig().getString("Prefix") + tpPlayerNotFound + args[0]);
                }
                player.sendMessage(plugin.getConfig().getString("Prefix") + ChatColor.RED + "Could not find player " + args[0] + "!");
                return true;
            }
            player.teleport(target.getLocation());
            return true;
            
            


            // If the player (or console) uses our command correct, we can return true
            return true;
        }
        return false;
    }
}