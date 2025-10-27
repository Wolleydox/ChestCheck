package de.wolley.config;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;


public class ConfigManager {
    private final JavaPlugin plugin;

    private Map<Material, Integer> itemLimits = new HashMap<>();
    private String limitMessage;
    private String prefix;
    private String destroyMessage;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        prefix = ChatColor.translateAlternateColorCodes('&', config.getString("prefix", "&7[&cChestLimit&7] ") + " ");

        limitMessage = config.getString("limit_message", "Diese Truhe ist gesperrt!");

        destroyMessage = config.getString("destroy_message", "Du darfst diese Kiste nicht abbauen.");

        itemLimits.clear();
        if (config.isConfigurationSection("limits")) {
            for (String key : config.getConfigurationSection("limits").getKeys(false)) {
                try {
                    Material material = Material.valueOf(key.toUpperCase());
                    int limit = config.getInt("limits." + key);
                    itemLimits.put(material, limit);
                } catch (IllegalArgumentException e) {
                    plugin.getLogger().warning("Ungültiges Material in der Config: " + key);
                }
            }
        }
    }

    public String getDestroyMessage() {
        return destroyMessage;
    }

    public String getPrefix() {
        return prefix;
    }

    public Map<Material, Integer> getItemLimits() {
        return itemLimits;
    }

    public String getLimitMessage() {
        return limitMessage;
    }

}