package org.craftystudios;


import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.craftystudios.utils.Logger;
import org.craftystudios.utils.Settings;
import org.craftystudios.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;
import org.craftystudios.commands.*;

import java.io.File;
import java.io.IOException;

public final class craftycore extends JavaPlugin {
    Plugin plugin = this;


    public File folder = plugin.getDataFolder();
    public File file = new File(folder + "homes.yml");
    public static YamlConfiguration homes = new YamlConfiguration();





    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("CraftyCore has been enabled!");
        this.getCommand("help").setExecutor(new CommandHelp());
        //Change resource id    ^^^^^
        new UpdateChecker(this, 53460).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.log(Logger.LogLevel.SUCCESS, ("CraftyCore is up to date!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore is running version " + this.getDescription().getVersion()));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Config..."));



            } else {
                Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
                Logger.log(Logger.LogLevel.WARNING, ("CraftyCore is outdated!"));
                Logger.log(Logger.LogLevel.WARNING, ("Newest version: " + version));
                Logger.log(Logger.LogLevel.WARNING, ("Your version: " + Settings.VERSION));
                Logger.log(Logger.LogLevel.WARNING, ("Please Update Here: " + Settings.PLUGIN_URL));
                Logger.log(Logger.LogLevel.OUTLINE, "*********************************************************************");
            }

        });
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //register the commands

        getCommand("Reload").setExecutor(new Reload(this));
        getCommand("CraftyCoreCommand").setExecutor(new CraftyCoreCommand());
        getCommand("CommandHelp").setExecutor(new CommandHelp());
        getCommand("Spawn").setExecutor(new Spawn(this));

        if(!folder.exists()) {
            folder.mkdir();
        }

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            homes.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

    }

        //register the events


    }













