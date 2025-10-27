package de.wolley.chestCheck;

import de.wolley.config.ConfigManager;
import de.wolley.events.ChestOpenListener;
import de.wolley.events.ChestProtectionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChestCheck extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {

        configManager = new ConfigManager(this);
        configManager.loadConfig();

        Bukkit.getPluginManager().registerEvents(new ChestOpenListener(configManager), this);
        Bukkit.getPluginManager().registerEvents(new ChestProtectionListener(configManager), this);

        getLogger().info("[------------------------------------]");
        getLogger().info("");
        getLogger().info("  ChestCheck System 1.0 wurde Aktiviert  ");
        getLogger().info("         Plugin by Wolleydox");
        getLogger().info("");
        getLogger().info("[------------------------------------]");
    }

    @Override
    public void onDisable() {
    }
}
