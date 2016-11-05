package org.devathon.contest2016.Entities;

import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class Label {

    public static void addLabel(String text, Block block) {
        ArmorStand as = (ArmorStand) block.getWorld().spawnEntity(block.getLocation(), EntityType.ARMOR_STAND);
        as.setVisible(false);
        as.setCustomNameVisible(true);
        as.setCustomName(text);
        as.setAI(false);
        as.setInvulnerable(true);
        as.setGravity(false);
        as.setMetadata("type", new LabelTypeMetadata("blank_antenna"));
        as.teleport(block.getLocation());
    }
}
