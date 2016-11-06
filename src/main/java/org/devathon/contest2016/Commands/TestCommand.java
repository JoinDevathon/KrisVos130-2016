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
import org.devathon.contest2016.Objects.Antenna;
import org.devathon.contest2016.Objects.AntennaManager;
import org.devathon.contest2016.Structures.Direction;
import org.devathon.contest2016.Structures.Structure;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        Structure structure = new Structure(Main.antenna);
        structure.buildStructure(((Player) sender).getLocation(), Direction.valueOf(args[0]));
        Label.addLabel("Antenna - Click me to configure", ((Player) sender).getLocation().getBlock());

        for (Antenna antenna : AntennaManager.antennas) {
            Bukkit.broadcastMessage("Antenna: " + antenna.getFrequency());
        }
        Bukkit.broadcastMessage(AntennaManager.antennas.size() + " - antennas");

        return false;
    }
}
