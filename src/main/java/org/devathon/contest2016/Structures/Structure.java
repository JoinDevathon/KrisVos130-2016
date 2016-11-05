package org.devathon.contest2016.Structures;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class Structure {

    private ArrayList<StructureBlock> structureBlocks;

    public Structure(ArrayList<StructureBlock> structureBlocks) {
        this.structureBlocks = structureBlocks;
    }

    public ArrayList<StructureBlock> getStructureBlocks() {
        return structureBlocks;
    }

    public void buildStructure(Location location, Direction direction) {
        Block startingBlock = location.getBlock();
        World world = location.getWorld();
        for (StructureBlock sb : getStructureBlocks()) {
            int x, y = sb.getYOffset(), z;
            if (direction == Direction.NORTH) {
                x = sb.getXOffset();
                z = sb.getZOffset();
            }  else if (direction == Direction.SOUTH) {
                if (sb.getXOffset() > 0) {
                    x = -sb.getXOffset();
                } else {
                    x = -sb.getXOffset();
                }
                z = -sb.getZOffset();
            } else if (direction == Direction.EAST) {
                if (sb.getXOffset() > 0) {
                    z = sb.getXOffset();
                } else {
                    z = sb.getXOffset();
                }
                if (sb.getZOffset() > 0) {
                    x = -sb.getZOffset();
                } else {
                    x = -sb.getZOffset();
                }
            } else {
                if (sb.getXOffset() > 0) {
                    z = -sb.getXOffset();
                } else {
                    z = -sb.getXOffset();
                }
                if (sb.getZOffset() > 0) {
                    x = sb.getZOffset();
                } else {
                    x = sb.getZOffset();
                }
            }
            startingBlock.getRelative(x, y, z).setType(sb.getMaterial());
        }
    }
}
