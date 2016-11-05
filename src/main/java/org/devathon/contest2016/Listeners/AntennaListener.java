package org.devathon.contest2016.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.devathon.contest2016.Objects.Antenna;
import org.devathon.contest2016.Objects.AntennaManager;

public class AntennaListener implements Listener {

    public void onClick(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null) {
            Antenna antenna = AntennaManager.getAntenna(e.getClickedBlock());
            if (antenna != null) {
                //Open GUI
                antenna.setFrequency(35.2);
            }
        }
    }
}
