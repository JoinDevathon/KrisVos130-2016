package org.devathon.contest2016.Structures;

import org.bukkit.Material;

public class StructureBlock {

    private int xOffset, yOffset, zOffset;
    private Material material;
    private short metadata;
    //TODO Bukkit Type and metadata

    public StructureBlock(int xOffset, int yOffset, int zOffset, Material material) {
        this(xOffset, yOffset, zOffset, material, (short) 0);
    }

    public StructureBlock(int xOffset, int yOffset, int zOffset, Material material, short metadata) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
        this.material = material;
        this.metadata = metadata;
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getYOffset() {
        return yOffset;
    }

    public int getZOffset() {
        return zOffset;
    }

    public Material getMaterial() {
        return material;
    }

    public short getMetadata() {
        return metadata;
    }
}
