package de.wolley.events;

import de.wolley.config.ConfigManager;
import de.wolley.utils.ChestUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.Inventory;

import java.util.Iterator;
import java.util.List;

public class ChestProtectionListener implements Listener {

    private final ConfigManager configManager;
    private static final String PERMISSION = "admin.openchest";

    public ChestProtectionListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onChestBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType() != Material.CHEST && block.getType() != Material.TRAPPED_CHEST) return;

        Player player = event.getPlayer();
        if (!player.hasPermission(PERMISSION)) {
            event.setCancelled(true);
            player.sendMessage(configManager.getPrefix() + configManager.getDestroyMessage());
        }
    }

    @EventHandler
    public void onExplosion(EntityExplodeEvent event) {
        List<Block> blocks = event.blockList();
        Iterator<Block> iterator = blocks.iterator();

        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST) {
                Chest chest = (Chest) block.getState();
                Inventory inventory = chest.getInventory();
                if (ChestUtils.isChestOverLimit(inventory, configManager.getItemLimits())) {
                    iterator.remove();
                }
            }
        }
    }
}
