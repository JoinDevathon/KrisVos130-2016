package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.Commands.TestCommand;
import org.devathon.contest2016.Structures.StructureBlock;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static ArrayList<StructureBlock> antenna;
    private static Plugin plugin;

    @Override
    public void onEnable() {
        // put your enable code here
        Bukkit.broadcastMessage("TEST!");
        getCommand("test").setExecutor(new TestCommand());
        antenna = new ArrayList<>();
        antenna.add(new StructureBlock(0, 0, 0, Material.BRICK));
        antenna.add(new StructureBlock(-1, 0, -1, Material.getMaterial(44)));
        antenna.add(new StructureBlock(1, 0, 1, Material.getMaterial(44)));
        antenna.add(new StructureBlock(-1, 0, 1, Material.getMaterial(44)));
        antenna.add(new StructureBlock(1, 0, -1, Material.getMaterial(44)));
        antenna.add(new StructureBlock(1, 0, 0, Material.getMaterial(44)));
        antenna.add(new StructureBlock(0, 0, 1, Material.getMaterial(44)));
        antenna.add(new StructureBlock(-1, 0, 0, Material.getMaterial(44)));
        antenna.add(new StructureBlock(0, 0, -1, Material.getMaterial(44)));
        antenna.add(new StructureBlock(0, 1, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 2, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 4, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(1, 2, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 2, -1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(1, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(2, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 3, -1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 3, -2, Material.IRON_FENCE));
        antenna.add(new StructureBlock(-1, 4, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 4, -1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(-1, 5, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(-2, 5, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, -1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, -2, Material.IRON_FENCE));
        plugin = this;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // put your disable code here
    }
}

