package org.devathon.contest2016.Objects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.metadata.MetadataValue;
import org.devathon.contest2016.Entities.Label;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AntennaManager {

    public static ArrayList<Antenna> antennas = new ArrayList<>();

    public static void addAntenna(ArmorStand label, boolean byName) {
        Bukkit.broadcastMessage("ADD ANTENNA!!!");
        double frequency = 0;
        if (byName) {
            if (label.getCustomName().startsWith("Antenna - Frequency")) {
                String freq = label.getCustomName().replace("Antenna - Frequency ", "");
                frequency = Double.parseDouble(freq);
            }
        } else {
            if (Label.getMetadataInt(label, "type") == 2) {
                frequency = Label.getMetadataDouble(label, "frequency");
            }
        }
        antennas.add(new Antenna(label.getLocation().add(0, 1, 0).getBlock(), frequency, label));
    }

    public static void addAntenna(Block block, double frequency, ArmorStand label) {
        antennas.add(new Antenna(block, frequency, label));
    }

    public static Antenna getAntenna(Block block) {
        for (Antenna antenna : antennas) {
            Bukkit.broadcastMessage(block.getLocation().getX() + " - " + block.getLocation().getY() + " - " + block.getLocation().getZ());
            Bukkit.broadcastMessage(antenna.getCore().getLocation().getX() + " - " + antenna.getCore().getLocation().getY() + " - " + antenna.getCore().getLocation().getZ());
            Bukkit.broadcastMessage("---");
            if (block.equals(antenna.getCore())) {
                return antenna;
            }
        }
        return null;
    }
}
