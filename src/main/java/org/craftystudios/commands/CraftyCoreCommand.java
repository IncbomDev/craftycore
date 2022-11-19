package org.craftystudios.commands;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import craftystudios.org.craftystudios.utils.Settings;

public class CraftyCoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("§6§lCraftyStudios §7§l» §f§lRunning on version " + SETTINGS.VERSION);
            return false;
        }
        return false;
    }
}
