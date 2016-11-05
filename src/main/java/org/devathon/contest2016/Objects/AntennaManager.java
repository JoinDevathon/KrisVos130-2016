package org.devathon.contest2016.Objects;

import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;

public class AntennaManager {

    public static ArrayList<Antenna> antennas = new ArrayList<>();

    public static void init() {
        //Initialize all antennas
    }

    public static void addAntenna(Block block, double frequency, ArmorStand label) {
        antennas.add(new Antenna(block, frequency, label));
    }

    public static Antenna getAntenna(Block block) {
        for (Antenna antenna : antennas) {
            if (block.equals(antenna.getCore())) {
                return antenna;
            }
        }
        return null;
    }
}
