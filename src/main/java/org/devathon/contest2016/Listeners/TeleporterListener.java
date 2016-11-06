package org.devathon.contest2016.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.devathon.contest2016.Main;
import org.devathon.contest2016.Objects.Teleporter;
import org.devathon.contest2016.Objects.TeleporterManager;

import java.util.HashMap;
import java.util.UUID;

public class TeleporterListener implements Listener {

    public static HashMap<UUID, Integer> teleporting = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null && e.getHand() == EquipmentSlot.HAND) {
            Teleporter teleporter = TeleporterManager.getTeleporter(e.getClickedBlock());
            Bukkit.broadcastMessage(teleporter + "");
            if (teleporter != null && teleporter.getFrequency() == 0) {
                Main.teleporterFrequencies.put(e.getPlayer().getUniqueId(), teleporter);
                e.getPlayer().sendMessage("Please enter the frequency you would like this to use in chat.");
            }
        }
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onMove(PlayerMoveEvent e) {
        if (teleporting.get(e.getPlayer().getUniqueId()) == null) {
            Block block = e.getTo().getBlock().getRelative(0, -1, 0);
            final Teleporter teleporter = TeleporterManager.getTeleporter(block);
            if (teleporter != null && teleporter.getFrequency() > 0) {
                int id = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), new Runnable() {
                    int state = 0;
                    Teleporter target;

                    @Override
                    public void run() {
                        if (!teleporter.getCore().equals(e.getPlayer().getPlayer().getLocation().getBlock().getRelative(0, -1, 0))) {
                            e.getPlayer().sendMessage("Teleportation cancelled.");
                            int id = teleporting.get(e.getPlayer().getUniqueId());
                            teleporting.remove(e.getPlayer().getUniqueId());
                            Bukkit.getScheduler().cancelTask(id);
                        } else {
                            state++;
                            String message = "";
                            e.getPlayer().getWorld().playEffect(teleporter.getCore().getLocation().add(0, 1, 0), Effect.COLOURED_DUST, 1);
                            switch(state) {
                                case 1:
                                    message = "Initiating MCTeleport v1.1";
                                    break;
                                case 2:
                                    message = "Loading module 'teleporter'";
                                    break;
                                case 3:
                                    message = "Loading module 'quantum'";
                                    break;
                                case 4:
                                    message = "Loading module 'cleanup'";
                                    break;
                                case 5:
                                    message = "Added cleanup scheduler.";
                                    break;
                                case 6:
                                    message = "Initiating teleport.";
                                    break;
                                case 7:
                                    message = "Locating other target.";
                                    target = TeleporterManager.getOtherTeleporter(teleporter);
                                    break;
                                case 8:
                                    if (target == null) {
                                        message = "ERR: Teleporter not found.";
                                        state = 10;
                                    } else {
                                        message = "Initiating teleportation...";
                                        state = 9;
                                    }
                            }
                            e.getPlayer().sendMessage(message);
                            if (state == 9) {
                                e.getPlayer().teleport(target.getCore().getLocation().add(0.5, 1, 0.5));
                                int id = teleporting.get(e.getPlayer().getUniqueId());
                                teleporting.remove(e.getPlayer().getUniqueId());
                                Bukkit.getScheduler().cancelTask(id);
                            } else if (state == 10) {
                                int id = teleporting.get(e.getPlayer().getUniqueId());
                                teleporting.remove(e.getPlayer().getUniqueId());
                                Bukkit.getScheduler().cancelTask(id);
                            }
                        }
                    }
                }, 20L, 20L);
                teleporting.put(e.getPlayer().getUniqueId(), id);
            }
        }
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onChat(PlayerChatEvent e) {
        Teleporter teleporter = Main.teleporterFrequencies.get(e.getPlayer().getUniqueId());
        if (teleporter != null) {
            try {
                double frequency = Double.parseDouble(e.getMessage());
                if (frequency > 0) {
                    int freqsFound = 0;
                    for (Teleporter teleporter1 : TeleporterManager.teleporters) {
                        if (teleporter1.getFrequency() == frequency) {
                            freqsFound++;
                        }
                    }
                    if (freqsFound < 2) {
                        teleporter.setFrequency(frequency);
                        e.getPlayer().sendMessage("Set teleporter frequency to " + frequency);
                        Main.teleporterFrequencies.remove(e.getPlayer().getUniqueId());
                    } else {
                        e.getPlayer().sendMessage("There are already two teleporters with that frequency.");
                    }
                } else {
                    e.getPlayer().sendMessage("Please enter a frequency that is higher than 0.");
                }
                e.setCancelled(true);
            } catch(NumberFormatException ex) {
                e.getPlayer().sendMessage("Invalid frequency. Please try again.");
            }
        }
    }
}
