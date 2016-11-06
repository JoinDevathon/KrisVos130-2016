package org.devathon.contest2016.Objects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.metadata.MetadataValue;
import org.devathon.contest2016.Entities.Label;

import java.util.Collection;
import java.util.List;

public class MachineManager {

    public static void init() {
        World world = Bukkit.getWorld("world");
        Collection<ArmorStand> armorStands = world.getEntitiesByClass(ArmorStand.class);
        Bukkit.broadcastMessage("ArmorStands - " + armorStands.size());
        for (ArmorStand as : armorStands) {
            switch(as.getCustomName()) {
                case "Antenna - Click me to configure":
                    AntennaManager.addAntenna(as, true);
                    break;
                default:
                    if (as.getCustomName().startsWith("Computer - Frequency")) {
                        AntennaManager.addAntenna(as, true);
                    }
                    break;
            }
        }
    }

}
