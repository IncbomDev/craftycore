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
import io.sentry.Sentry;
import java.lang.Exception;


public final class CraftyCore extends JavaPlugin {
    
   

    Plugin plugin = this;


    public File folder = plugin.getDataFolder();
    public File file = new File(folder + "homes.yml");
    public static YamlConfiguration homes = new YamlConfiguration();





    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * Register the EventListener here, when PlaceholderAPI is installed.
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        }else{
            Logger.log(Logger.LogLevel.WARNING, ("PlaceholderAPI not found, disabling!"));
            Bukkit.getPluginManager().disablePlugin(this);

        }
        // Plugin startup logic
        System.out.println("CraftyCore has been enabled!");
        this.getCommand("help").setExecutor(new CommandHelp());
        //Change resource id    ^^^^^
        new UpdateChecker(this, 53460).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.log(Logger.LogLevel.SUCCESS, ("CraftyCore is up to date!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore is running version " + this.getDescription().getVersion()));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Config..."));
                loadConfig();
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Config Loaded!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Homes..."));
                loadHomes();
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Homes Loaded!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Commands..."));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Commands Loaded!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Events..."));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Events Loaded!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Metrics..."));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Metrics Loaded!"));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Loading Sentry..."));
                Logger.log(Logger.LogLevel.INFO, ("CraftyCore: Sentry Loaded!"));



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
        getCommand("Homes").setExecutor(new Homes(this));
        getCommand("SetHomeCommand").setExecutor(new SetHomeCommand(this));
        

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

    }

        //register the events


    














