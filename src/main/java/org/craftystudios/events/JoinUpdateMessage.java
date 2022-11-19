
package org.craftystudios.events;

import org.craftystudios.craftycore;
import org.craftystudios.utils.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinUpdateMessage implements Listener {


    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(getConfig().getBoolean("barapi") == true){
            if (args[0].equalsIgnoreCase("website")) {
                BarAPI.setMessage(player, getConfig().getString("website"), 10);

            if (p.hasPermission("pluginname.update")) {
                //PLEASE REPLACE THE RESOURCE ID WITH YOUR SPIGOT RESOURCE
                new UpdateChecker(craftycore.getPlugin(), 53460).getLatestVersion(version -> {
                    if (!craftycore.plugin.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");
                        p.sendMessage(ChatColor.RED + "PluginName is outdated!");
                        p.sendMessage(ChatColor.RED + "Newest version: " + version);
                        p.sendMessage(ChatColor.RED + "Your version: " + ChatColor.BOLD + Settings.VERSION);
                        p.sendMessage(ChatColor.GOLD + "Please Update Here: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                        p.sendMessage(ChatColor.GRAY + "****************************************************************");                    }
                });
            }
        }
    }
}
    