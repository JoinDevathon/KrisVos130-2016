package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.Commands.TestCommand;
import org.devathon.contest2016.Listeners.AntennaListener;
import org.devathon.contest2016.Objects.Antenna;
import org.devathon.contest2016.Objects.MachineManager;
import org.devathon.contest2016.Structures.StructureBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static ArrayList<StructureBlock> antenna;
    public static HashMap<UUID, Antenna> antennaFrequencies = new HashMap<>();
    private static Plugin plugin;

    @Override
    public void onEnable() {
        // put your enable code here
        Bukkit.broadcastMessage("TEST!");
        getCommand("test").setExecutor(new TestCommand());
        antenna = new ArrayList<>();
        antenna.add(new StructureBlock(0, 0, 0, Material.getMaterial(98)));
        antenna.add(new StructureBlock(-1, 0, -1, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(1, 0, 1, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(-1, 0, 1, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(1, 0, -1, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(1, 0, 0, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(0, 0, 1, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(-1, 0, 0, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(0, 0, -1, Material.getMaterial(44), (short) 5));
        antenna.add(new StructureBlock(0, 1, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 2, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 4, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(1, 2, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(-1, 2, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(1, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(2, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(-1, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(-2, 3, 0, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 4, 1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 4, -1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, -1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, -2, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, 1, Material.IRON_FENCE));
        antenna.add(new StructureBlock(0, 5, 2, Material.IRON_FENCE));
        MachineManager.init();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new AntennaListener(), this);
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

