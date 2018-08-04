package me.hsgamer.breakeffect;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.LinkedList;

public class Listeners implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Location loc = e.getBlock().getLocation().add(0.5, 0.5, 0.5);
        Material block = e.getBlock().getType();
        if (!DataStorage.storeParticle.containsKey(block)) return;
        Particle effect = DataStorage.getParticle(block);
        LinkedList<Float> data = DataStorage.getData(block);
        float offsetX = data.get(0);
        float offsetY = data.get(1);
        float offsetZ = data.get(2);
        int count = data.get(3).intValue();
        float second = data.get(4);
        loc.getWorld().spawnParticle(effect, loc, count, offsetX, offsetY, offsetZ, second);
    }

}
