package me.steakfisher.damagehalver;

import me.steakfisher.damagehalver.listeners.DamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageHalver extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
