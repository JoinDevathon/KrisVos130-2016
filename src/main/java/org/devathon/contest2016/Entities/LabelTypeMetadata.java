package org.devathon.contest2016.Entities;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.devathon.contest2016.Main;

public class LabelTypeMetadata implements MetadataValue {

    int i;

    public LabelTypeMetadata(String type) {
        switch(type) {
            case "blank_antenna":
                i = 1;
                break;
            case "antenna":
                i = 2;
                break;
        }
    }

    @Override
    public Object value() {
        return i;
    }

    @Override
    public int asInt() {
        return i;
    }

    @Override
    public float asFloat() {
        return i;
    }

    @Override
    public double asDouble() {
        return i;
    }

    @Override
    public long asLong() {
        return i;
    }

    @Override
    public short asShort() {
        return 0;
    }

    @Override
    public byte asByte() {
        return 0;
    }

    @Override
    public boolean asBoolean() {
        return false;
    }

    @Override
    public String asString() {
        return i + "";
    }

    @Override
    public Plugin getOwningPlugin() {
        return Main.getPlugin();
    }

    @Override
    public void invalidate() {

    }
}
