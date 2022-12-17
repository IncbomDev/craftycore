package org.craftystudios.commands;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.craftystudios.utils.Settings;

public class CraftyCoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {

            if( args.length == 0) {
                sender.sendMessage("§6§lCrafty§e§lCore §7- §fHelp");
                sender.sendMessage("§7§m-------------------------------------");
                sender.sendMessage("§6§l/craftycore §7- §fShows the help command");
                sender.sendMessage("§6§l/craftycore help §7- §fShows this help menu");
                sender.sendMessage("§6§l/craftycore reload §7- §fReloads the config");
            }
            if(args.length == 1 || args[1].equalsIgnoreCase("help")) {
                sender.sendMessage("§6§lCrafty§e§lCore §7- §fHelp");
                sender.sendMessage("§7§m-------------------------------------");
                sender.sendMessage("§6§l/craftycore §7- §fShows the help command");
                sender.sendMessage("§6§l/craftycore help §7- §fShows this help menu");
                sender.sendMessage("§6§l/craftycore reload §7- §fReloads the config");
            }
            if(args.length == 1 || args[1].equalsIgnoreCase("reload")) { 
                if (sender.hasPermission("craftycore.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("reload-message")));
            
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("no-permission")));

                }
            }
            
        }
        return false;
    }
}

