# 🧰 ChestCheck

**ChestCheck** is a lightweight Minecraft plugin that automatically checks player chests and prevents them from storing too many of certain items.  
It helps server owners maintain fair gameplay by limiting how many valuable materials a chest can contain.  

---

## ⚙️ Features

- 📦 **Item Limits per Chest** – Set a maximum number of specific items per chest.  
- 🛑 **Automatic Chest Locking** – Chests that exceed limits are automatically locked.  
- 💬 **Custom Messages** – Fully configurable messages and prefixes in `config.yml`.  
- ⚙️ **Simple Setup** – Define your own limits for diamonds, iron, gold, or any material.  
- 🔒 **Protection System** – Prevents players from breaking locked or restricted chests.  
- 🧩 **Lightweight & Fast** – Designed for performance on all Spigot and Paper servers.  

---

## 🚀 Installation

1. Download the latest **ChestCheck.jar** file.  
2. Place it inside your server’s `plugins` folder.  
3. Start or reload your Minecraft server.  
4. Open the generated `config.yml` and customize it to your needs.  

---

## ⚙️ Configuration Example (`config.yml`)

```yml
prefix: "&7[&cChestLimit&7] "

limit_message: "Diese Truhe wurde gesperrt, da zu viele Items enthalten sind!"
destroy_message: "Du darfst diese Kiste nicht abbauen."

limits:
  DIAMOND: 10
  IRON_INGOT: 64
  GOLD_INGOT: 32
```

### 🧠 Explanation
- **prefix** → Prefix shown before messages in chat.  
- **limit_message** → Sent when a chest is locked due to exceeding limits.  
- **destroy_message** → Sent when a player tries to break a protected chest.  
- **limits** → Set item-specific maximum amounts per chest (by Minecraft material name).  

---

## 🔐 Permissions

| Permission | Description |
|-------------|-------------|
| `admin.openchest` | Allows a player to bypass item limits and protection. |

*(You can easily customize or expand permissions in your plugin.yml file.)*

---

## 🧠 Developer Information

ChestCheck is developed in **Java** using the **Spigot API**.  
It listens to chest-related events and enforces limits dynamically through smart event handling and configuration management.  

- **Main Class:** `de.wolley.chestCheck.ChestCheck`  
- **Event Listeners:** `ChestOpenListener`, `ChestProtectionListener`  
- **Config Manager:** `ConfigManager`  
- **Utility Class:** `ChestUtils`

---

## ❤️ Contributing

Contributions are always welcome!  
If you find a bug or have an idea for improvement, feel free to open an issue or pull request on GitHub.  

---

## 📜 License

This project is licensed under the **MIT License**.  
You’re free to use, modify, and share the plugin with proper credit.  

---

## 💬 Final Notes

ChestCheck keeps your Minecraft world fair and balanced by automatically controlling how many items each chest can store.  
Whether you’re running a survival, economy, or PvP server — **ChestCheck** ensures fair play for everyone.
