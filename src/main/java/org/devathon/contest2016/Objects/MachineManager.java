package org.devathon.contest2016.Objects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;

import java.util.Collection;

public class MachineManager {

    public static void init() {
        World world = Bukkit.getWorld("world");
        Collection<ArmorStand> armorStands = world.getEntitiesByClass(ArmorStand.class);
        for (ArmorStand as : armorStands) {
            switch(as.getCustomName()) {
                case "Teleporter - Click me to configure":
                    TeleporterManager.addTeleporter(as, true);
                    break;
                default:
                    if (as.getCustomName().startsWith("Teleporter - Frequency")) {
                        TeleporterManager.addTeleporter(as, true);
                    }
                    break;
            }
        }
    }

}
