package org.craftystudios.commands;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Reload extends JavaPlugin {

    FileConfiguration config;
    File cfile;



    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("craftycore reload")) {
            config = YamlConfiguration.loadConfiguration(cfile);
            sender.sendMessage(ChatColor.GREEN + "Reloaded CraftyCore's config!");
        }
        return true;
    }
}