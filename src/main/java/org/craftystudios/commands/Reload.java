package org.craftystudios.commands;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Reload implements CommandExecutor {
    private final JavaPlugin plugin;

    public Reload(JavaPlugin plugin) {
        Player player = (Player) sender;
        player.sendMessage(plugin.getConfig().getString("reloadMessage"));
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    }
}
