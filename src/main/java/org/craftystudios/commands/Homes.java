package org.craftystudios.commands;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
<<<<<<< Updated upstream
import org.craftystudios.craftycore;

import java.io.File;
=======

import java.io.File;
import java.io.IOException;
>>>>>>> Stashed changes

public class Homes implements CommandExecutor {
    private final JavaPlugin plugin;

<<<<<<< Updated upstream
    public SetHomeCommand(JavaPlugin plugin) {
=======
    public Homes(JavaPlugin plugin) {
>>>>>>> Stashed changes
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
                File file = new File(plugin.getDataFolder() + "/homes.yml");
                YamlConfiguration homes = YamlConfiguration.loadConfiguration(file);
                if (homes.get("homes." + player.getUniqueId() + "." + homeName) == null) {
                    player.sendMessage(ChatColor.RED + "Home not found!");
                    return true;
<<<<<<< Updated upstream
                }else {
=======
                } else {
>>>>>>> Stashed changes
                    Location location = new Location(
                            plugin.getServer().getWorld(homes.getString("homes." + player.getUniqueId() + "." + homeName + ".world")),
                            homes.getDouble("homes." + player.getUniqueId() + "." + homeName + ".x"),
                            homes.getDouble("homes." + player.getUniqueId() + "." + homeName + ".y"),
                            homes.getDouble("homes." + player.getUniqueId() + "." + homeName + ".z"),
                            (float) homes.getDouble("homes." + player.getUniqueId() + "." + homeName + ".yaw"),
                            (float) homes.getDouble("homes." + player.getUniqueId() + "." + homeName + ".pitch")
                    );
                    player.teleport(location);
<<<<<<< Updated upstream
                    player.sendMessage.ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("HomeTeleported"));
                    return true;
                }
                try {
                    homes.save(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                player.sendMessage(ChatColor.GREEN + "Home set!");
                return true;
            }
        }
=======
                    player.sendMessage(ChatColor.GREEN + "Teleported to home " + homeName);
                    try {
                        homes.save(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } player.sendMessage(ChatColor.GREEN + "Home set!");

                    return true;
                }



            }
        }
        return false;
>>>>>>> Stashed changes
    }
}