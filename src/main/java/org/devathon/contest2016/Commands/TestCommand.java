package org.devathon.contest2016.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.devathon.contest2016.Entities.Label;
import org.devathon.contest2016.Main;
import org.devathon.contest2016.Structures.Direction;
import org.devathon.contest2016.Structures.Structure;
import org.devathon.contest2016.Structures.StructureBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Structure structure = new Structure(Main.antenna);
        structure.buildStructure(((Player) sender).getLocation(), Direction.valueOf(args[0]));
        Label.addLabel("Antenna - Click me to configure", ((Player) sender).getLocation().getBlock());

        Collection<Entity> entities = p.getWorld().getNearbyEntities(p.getLocation(), 10, 10, 10);
        for (Entity entity : entities) {
            if (entity instanceof ArmorStand) {
                ArmorStand as;
                List<MetadataValue> values = entity.getMetadata("type");
                for (MetadataValue val : values) {
                    Bukkit.broadcastMessage(val.asString());
                }
            }
        }

        return false;
    }
}
