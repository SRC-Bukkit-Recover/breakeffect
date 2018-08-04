package me.hsgamer.breakeffect;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.LinkedList;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GOLD + "==================================");
            sender.sendMessage(ChatColor.BLUE + "Plugin: " + ChatColor.WHITE + BreakEffect.plugin.getDescription().getName());
            sender.sendMessage(ChatColor.BLUE + "Author: " + ChatColor.WHITE + BreakEffect.plugin.getDescription().getAuthors());
            sender.sendMessage(ChatColor.BLUE + "Version: " + ChatColor.WHITE + BreakEffect.plugin.getDescription().getVersion());
            sender.sendMessage(ChatColor.GOLD + "==================================");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.RED + "/" + command.getName() + " reload");
                sender.sendMessage(ChatColor.RED + "/" + command.getName() + " help");
            } else if (args[0].equalsIgnoreCase("reload")) {
                BreakEffect.plugin.getConfig().options().copyHeader(true);
                BreakEffect.plugin.reloadConfig();
                DataStorage.clear();

                for (String e : BreakEffect.plugin.getConfig().getStringList("blocks")) {
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
                    sender.sendMessage(ChatColor.GREEN + temp[0] + "has been added successfully");
                }

                sender.sendMessage(ChatColor.GREEN + BreakEffect.plugin.getDescription().getName() + " Reloaded");
            }
        }
        return true;
    }

}
