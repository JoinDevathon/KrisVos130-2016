package org.devathon.contest2016.Objects;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.devathon.contest2016.Entities.Label;

import java.util.ArrayList;

public class TeleporterManager {

    public static ArrayList<Teleporter> teleporters = new ArrayList<>();

    public static void addTeleporter(ArmorStand label, boolean byName) {
        double frequency = 0;
        if (byName) {
            if (label.getCustomName().startsWith("Teleporter - Frequency")) {
                String freq = label.getCustomName().replace("Teleporter - Frequency ", "");
                frequency = Double.parseDouble(freq);
            }
        } else {
            if (Label.getMetadataInt(label, "type") == 2) {
                frequency = Label.getMetadataDouble(label, "frequency");
            }
        }
        teleporters.add(new Teleporter(label.getLocation().getBlock(), frequency, label));
    }

    public static void addTeleporter(Block block, double frequency, ArmorStand label) {
        teleporters.add(new Teleporter(block, frequency, label));
    }

    public static Teleporter getTeleporter(Block block) {
        for (Teleporter teleporter : teleporters) {
            if (block.equals(teleporter.getCore())) {
                return teleporter;
            }
        }
        return null;
    }

    public static Teleporter getOtherTeleporter(Teleporter currentTeleporter) {
        for (Teleporter teleporter : teleporters) {
            if (teleporter.getFrequency() == currentTeleporter.getFrequency() && teleporter != currentTeleporter) {
                return teleporter;
            }
        }
        return null;
    }
}
