package org.craftystudios.utils;

import org.craftystudios.CraftyCore;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;
import java.io.InputStream;
@SuppressWarnings("unused")

public class UpdateChecker {
    private int resourceId;
    private CraftyCore plugin;
    public UpdateChecker (CraftyCore plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
                                                }
    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getLogger().info("Cannot look for updates: " + exception.getMessage());
                this.plugin.getLogger().info("Please check for updates manually at: " + Settings.PLUGIN_URL);
            }
        });
    }
}