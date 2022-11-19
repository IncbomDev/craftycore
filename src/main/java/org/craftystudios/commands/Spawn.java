package org.craftystudios.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Spawn extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(getConfig().getString("Prefix") + ChatColor.RED + "You can only run this command as a player!");
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length == 0) {
                for (String tpNoPlayer : getConfig().getStringList("tpNoPlayer")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix")+ tpNoPlayer));
                }
                p.sendMessage(ChatColor.RED + "Please specify a player.");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                for (String tpPlayerNotFound : getConfig().getStringList("tpPlayerNotFound")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix") + tpPlayerNotFound));
                }
                for (String tpPlayerNotFound : getConfig().getStringList("tpPlayerNotFound")) {
                    p.sendMessage(getConfig().getString("Prefix") + tpPlayerNotFound + args[0]);
                }
                p.sendMessage(getConfig().getString("Prefix") + ChatColor.RED + "Could not find player " + args[0] + "!");
                return true;
            }
            p.teleport(target.getLocation());
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            getConfig().set("spawn.world", p.getLocation().getWorld().getName());
            getConfig().set("spawn.x", p.getLocation().getX());
            getConfig().set("spawn.y", p.getLocation().getY());
            getConfig().set("spawn.z", p.getLocation().getZ());
            saveConfig();
            for (String setspawnmessage : getConfig().getStringList("setspawn-message")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix") + setspawnmessage));
            }

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (getConfig().getConfigurationSection("spawn") == null) {
                for (String spawnnotset : getConfig().getStringList("spawn-not-set")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix") + spawnnotset));
                }

                return true;
            }
            World w = Bukkit.getServer().getWorld(getConfig().getString("spawn.world"));
            double x = getConfig().getDouble("spawn.x");
            double y = getConfig().getDouble("spawn.y");
            double z = getConfig().getDouble("spawn.z");
            p.teleport(new Location(w, x, y, z));
            for (String spawnMessage : getConfig().getStringList("spawnMessage"))
                p.sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Prefix") +  spawnMessage));
        }
        return true;
    }
}