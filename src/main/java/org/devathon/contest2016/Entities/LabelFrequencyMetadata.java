package org.devathon.contest2016.Entities;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.devathon.contest2016.Main;

public class LabelFrequencyMetadata implements MetadataValue {

    double d;

    public LabelFrequencyMetadata(double frequency) {
        d = frequency;
    }

    @Override
    public Object value() {
        return d;
    }

    @Override
    public int asInt() {
        return 0;
    }

    @Override
    public float asFloat() {
        return 0;
    }

    @Override
    public double asDouble() {
        return d;
    }

    @Override
    public long asLong() {
        return 0;
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
        return d + "";
    }

    @Override
    public Plugin getOwningPlugin() {
        return Main.getPlugin();
    }

    @Override
    public void invalidate() {

    }
}
