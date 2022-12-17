package org.craftystudios.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Spawn implements CommandExecutor {
    private final JavaPlugin plugin;

    public Spawn(JavaPlugin plugin) {
        this.plugin = plugin;

    }

    public file messages = new File(plugin.getDataFolder(), "messages.yml");
    public YamlConfiguration messagesConfig = YamlConfiguration.loadConfiguration(messages);


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("Prefix") + ChatColor.RED + "You can only run this command as a player!");
            return true;
        }
        
       

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length == 0) {
                for (String tpNoPlayer : plugin.getConfig().getStringList("tpNoPlayer")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix")+ tpNoPlayer));
                }
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("tpNoPlayer")));
                
                return true;
            }
            
        }

        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            plugin.getConfig().set("spawn.world", p.getLocation().getWorld().getName());
            plugin.getConfig().set("spawn.x", p.getLocation().getX());
            plugin.getConfig().set("spawn.y", p.getLocation().getY());
            plugin.getConfig().set("spawn.z", p.getLocation().getZ());
            plugin.saveConfig();
            for (String setspawnmessage : plugin.getConfig().getStringList("setspawn-message")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + setspawnmessage));
            }

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (plugin.getConfig().getConfigurationSection("spawn") == null) {
                for (String spawnnotset : plugin.getConfig().getStringList("spawn-not-set")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + spawnnotset));
                }

                return true;
            }
            World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
            double x = plugin.getConfig().getDouble("spawn.x");
            double y = plugin.getConfig().getDouble("spawn.y");
            double z = plugin.getConfig().getDouble("spawn.z");
            p.teleport(new Location(w, x, y, z));
            for (String spawnMessage : plugin.getConfig().getStringList("spawnMessage"))
                p.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("Prefix") +  spawnMessage));
        }
        return true;
    }
}