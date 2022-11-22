package org.craftystudios.commands;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.craftystudios.craftycore;

import java.io.File;

public class SetHomeCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public SetHomeCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify a home name!");
                return true;
            }
            if (args.length == 1) {
                String homeName = args[0];
                Location location = player.getLocation();
                File file = new File(plugin.getDataFolder() + "/homes.yml");
                YamlConfiguration homes = YamlConfiguration.loadConfiguration(file);
                homes.set("homes." + player.getUniqueId() + "." + homeName + ".world", location.getWorld().getName());
                homes.set("homes." + player.getUniqueId() + "." + homeName + ".x", location.getX());
                homes.set("homes." + player.getUniqueId() + "." + homeName + ".y", location.getY());
                homes.set("homes." + player.getUniqueId() + "." + homeName + ".z", location.getZ());
                homes.set("homes." + player.getUniqueId() + "." + homeName + ".yaw", location.getYaw());
                homes.set("homes." + player.getUniqueId() + "." + homeName + ".pitch", location.getPitch());
                try {
                    homes.save(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                player.sendMessage.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("HomeSet"));
                return true;
            }
        }


        return false;
    }

    }



