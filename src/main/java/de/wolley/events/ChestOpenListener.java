package de.wolley.events;

import de.wolley.config.ConfigManager;
import de.wolley.utils.ChestUtils;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ChestOpenListener implements Listener {

    private final ConfigManager configManager;
    private static final String PERMISSION = "admin.openchest";
    public ChestOpenListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onPlayerOpenChest(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block block = e.getClickedBlock();
        if (block == null || !(block.getState() instanceof Chest)) return;

        Player player = e.getPlayer();
        Chest chest = (Chest) block.getState();
        Inventory inventory = chest.getInventory();

        if (ChestUtils.isChestOverLimit(inventory, configManager.getItemLimits())) {
            if (!player.hasPermission(PERMISSION)) {
                e.setCancelled(true);
                player.sendMessage(configManager.getPrefix() + configManager.getLimitMessage());
            }
        }
    }

}
