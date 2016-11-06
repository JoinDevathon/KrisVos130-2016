package org.devathon.contest2016.Entities;

import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

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

    public static int getMetadataInt(ArmorStand as, String metadata) {
        List<MetadataValue> values = as.getMetadata(metadata);
        if (values.size() > 0) {
            return values.get(0).asInt();
        }
        return 0;
    }

    public static double getMetadataDouble(ArmorStand as, String metadata) {
        List<MetadataValue> values = as.getMetadata(metadata);
        if (values.size() > 0) {
            return values.get(0).asDouble();
        }
        return 0;
    }

    public static String getMetadataString(ArmorStand as, String metadata) {
        List<MetadataValue> values = as.getMetadata(metadata);
        if (values.size() > 0) {
            return values.get(0).asString();
        }
        return null;
    }
}
