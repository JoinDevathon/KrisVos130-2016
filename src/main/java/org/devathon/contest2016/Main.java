package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.Commands.AddTeleporterCommand;
import org.devathon.contest2016.Listeners.TeleporterListener;
import org.devathon.contest2016.Objects.Teleporter;
import org.devathon.contest2016.Objects.MachineManager;
import org.devathon.contest2016.Structures.StructureBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static ArrayList<StructureBlock> teleporter;
    public static HashMap<UUID, Teleporter> teleporterFrequencies = new HashMap<>();
    private static Plugin plugin;

    @Override
    public void onEnable() {
        getCommand("addtp").setExecutor(new AddTeleporterCommand());
        teleporter = new ArrayList<>();
        teleporter.add(new StructureBlock(0, 0, 0, Material.getMaterial(155), (short) 1));
        teleporter.add(new StructureBlock(1, 0, 0, Material.getMaterial(44), (short) 7));
        teleporter.add(new StructureBlock(0, 0, 1, Material.getMaterial(44), (short) 7));
        teleporter.add(new StructureBlock(-1, 0, 0, Material.getMaterial(44), (short) 7));
        teleporter.add(new StructureBlock(0, 0, -1, Material.getMaterial(44), (short) 7));

        teleporter.add(new StructureBlock(-1, 0, -1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(1, 0, 1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(-1, 0, 1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(1, 0, -1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(-1, 1, -1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(1, 1, 1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(-1, 1, 1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(1, 1, -1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(-1, 2, -1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(1, 2, 1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(-1, 2, 1, Material.getMaterial(155), (short) 2));
        teleporter.add(new StructureBlock(1, 2, -1, Material.getMaterial(155), (short) 2));

        teleporter.add(new StructureBlock(0, 4, 0, Material.getMaterial(198), (short) 1));
        teleporter.add(new StructureBlock(0, 3, 0, Material.getMaterial(201)));
        teleporter.add(new StructureBlock(-1, 3, -1, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(1, 3, 1, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(-1, 3, 1, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(1, 3, -1, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(1, 3, 0, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(0, 3, 1, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(-1, 3, 0, Material.getMaterial(205)));
        teleporter.add(new StructureBlock(0, 3, -1, Material.getMaterial(205)));

        MachineManager.init();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new TeleporterListener(), this);
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

