package me.hsgamer.breakeffect;

import org.bukkit.Material;
import org.bukkit.Particle;

import java.util.HashMap;
import java.util.LinkedList;

public class DataStorage {

    public static HashMap<Material, Particle> storeParticle = new HashMap<>();
    public static HashMap<Material, LinkedList<Float>> storeData = new HashMap<>();

    public static void store(Material material, Particle effect, LinkedList<Float> data) {
        storeParticle.put(material, effect);
        storeData.put(material, data);
    }

    public static Particle getParticle(Material material) {
        return storeParticle.get(material);
    }

    public static LinkedList<Float> getData(Material material) {
        return storeData.get(material);
    }

    public static void setParticle(Material material, Particle effect) {
        storeParticle.put(material, effect);
    }

    public static void setData(Material material, LinkedList<Float> data) {
        storeData.put(material, data);
    }

    public static void clear() {
        storeParticle.clear();
        storeData.clear();
    }
}
