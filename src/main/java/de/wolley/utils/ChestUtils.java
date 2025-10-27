package de.wolley.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ChestUtils {
    public static boolean isChestOverLimit(Inventory inventory, Map<Material, Integer> itemLimits) {
        for (Map.Entry<Material, Integer> entry : itemLimits.entrySet()) {
            Material material = entry.getKey();
            int limit = entry.getValue();

            int totalAmount = 0;
            for (ItemStack item : inventory.getContents()) {
                if (item != null && item.getType() == material) {
                    totalAmount += item.getAmount();
                }
            }

            if (totalAmount > limit) {
                return true;
            }
        }
        return false;
    }
}
