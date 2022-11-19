package org.craftystudios.events;

import org.craftystudios.craftycore;
import org.craftystudios.utils.Logger;
import org.craftystudios.utils.Settings;
import org.craftystudios.utils.UpdateChecker;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {


    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (craftycore.plugin.getConfig().getBoolean("enableUpdateNotifications") == true) {
            if (p.hasPermission("CraftyCore.update")) {
                //PLEASE REPLACE THE RESOURCE ID WITH YOUR SPIGOT RESOURCE
                new UpdateChecker(craftycore.getPlugin(), 53460).getLatestVersion(version -> {
                    if (!craftycore.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                        p.sendMessage(ChatColor.RED + "CraftyCore is outdated!");
                        p.sendMessage(ChatColor.RED + "Newest version: " + version);
                        p.sendMessage(ChatColor.RED + "Your version: " + ChatColor.BOLD + Settings.VERSION);
                        p.sendMessage(ChatColor.GOLD + "Please Update Here: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");                    }
                });
            }
        }
    }
}
