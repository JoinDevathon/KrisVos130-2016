package org.devathon.contest2016.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.devathon.contest2016.Main;
import org.devathon.contest2016.Objects.Antenna;
import org.devathon.contest2016.Objects.AntennaManager;

public class AntennaListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null) {
            Antenna antenna = AntennaManager.getAntenna(e.getClickedBlock());
            Bukkit.broadcastMessage(antenna + "");
            if (antenna != null) {
                Main.antennaFrequencies.put(e.getPlayer().getUniqueId(), antenna);
                e.getPlayer().sendMessage("Please enter the frequency you would like to use in chat.");
            }
        }
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onClick(PlayerChatEvent e) {
        Antenna antenna = Main.antennaFrequencies.get(e.getPlayer().getUniqueId());
        if (antenna != null) {
            try {
                double frequency = Double.parseDouble(e.getMessage());
                antenna.setFrequency(frequency);
                e.getPlayer().sendMessage("Set antenna frequency to " + frequency);
                Main.antennaFrequencies.remove(e.getPlayer().getUniqueId());
                e.setCancelled(true);
            } catch(NumberFormatException ex) {
                e.getPlayer().sendMessage("Invalid frequency. Please try again.");
            }
        }
    }
}
