package me.helix.atlasdeathchallenges;

import me.helix.atlasdeathchallenges.Listener.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin implements Listener {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @Override
    public void onEnable() {

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }

        Bukkit.getConsoleSender().sendMessage(color("&7============================================="));
        Bukkit.getConsoleSender().sendMessage(color("&l&eAtlas Death Challenges &7: &a1&7.&a1"));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(color("&eMade by &7: &eChelsea1124&7/&eHELIX"));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage(color("&eVersion &7: &a1&7.&a0&e+"));
        Bukkit.getConsoleSender().sendMessage(color("&7============================================="));

        this.getServer().getPluginManager().registerEvents(new Listeners(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

}
