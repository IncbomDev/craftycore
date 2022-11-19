package org.craftystudios;


import org.craftystudios.utils.Logger;
import org.craftystudios.utils.Settings;
import org.craftystudios.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;
import org.craftystudios.commands.*;



public final class craftycore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("CraftyCore has been enabled!");
        this.getCommand("help").setExecutor(new CommandHelp());
        //Change resource id    ^^^^^
        new UpdateChecker(this, 53460).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Logger.log(Logger.LogLevel.SUCCESS,("PluginName is up to date!"));
            } else {
                Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");
                Logger.log(Logger.LogLevel.WARNING,("CraftyCore is outdated!"));
                Logger.log(Logger.LogLevel.WARNING,("Newest version: " + version));
                Logger.log(Logger.LogLevel.WARNING,("Your version: " + Settings.VERSION));
                Logger.log(Logger.LogLevel.WARNING,("Please Update Here: " + Settings.PLUGIN_URL));
                Logger.log(Logger.LogLevel.OUTLINE,  "*********************************************************************");			}
        });
    }












}

