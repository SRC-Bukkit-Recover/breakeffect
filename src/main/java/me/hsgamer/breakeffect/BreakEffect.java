package me.hsgamer.breakeffect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public final class BreakEffect extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {

        plugin = getProvidingPlugin(this.getClass());

        DataStorage.clear();
        this.getConfig().options().copyHeader(true);
        saveDefaultConfig();

        for (String e : getConfig().getStringList("blocks")) {
            String[] temp = e.split(";");
            Material material = Material.valueOf(temp[0]);
            Particle effect = Particle.valueOf(temp[1]);
            LinkedList<Float> data = new LinkedList<Float>();
            data.add(Float.valueOf(temp[2]));
            data.add(Float.valueOf(temp[3]));
            data.add(Float.valueOf(temp[4]));
            data.add(Float.valueOf(temp[5]));
            data.add(Float.valueOf(temp[6]));
            DataStorage.store(material, effect, data);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + temp[0] + " has been added successfully to the storage");
        }

        this.getCommand("breakeffect").setExecutor(new Commands());

        getServer().getPluginManager().registerEvents(new Listeners(), this);

    }

    @Override
    public void onDisable() {

        HandlerList.unregisterAll(this);
        DataStorage.clear();
        plugin = null;

    }

}
