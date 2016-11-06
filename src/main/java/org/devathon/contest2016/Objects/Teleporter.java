package org.devathon.contest2016.Objects;

import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.devathon.contest2016.Entities.LabelFrequencyMetadata;

public class Teleporter {

    private Block core;
    private double frequency;
    private ArmorStand label;

    public Teleporter(Block core, double frequency, ArmorStand label) {
        this.core = core;
        this.frequency = frequency;
        this.label = label;
    }

    public Block getCore() {
        return core;
    }

    public double getFrequency() {
        return frequency;
    }

    public ArmorStand getLabel() {
        return label;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
        label.setMetadata("frequency", new LabelFrequencyMetadata(frequency));
        label.setCustomName("Teleporter - Frequency " + frequency);
    }
}
