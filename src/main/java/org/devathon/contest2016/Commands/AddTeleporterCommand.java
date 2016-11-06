package org.devathon.contest2016.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.devathon.contest2016.Entities.Label;
import org.devathon.contest2016.Main;
import org.devathon.contest2016.Objects.Teleporter;
import org.devathon.contest2016.Objects.TeleporterManager;
import org.devathon.contest2016.Structures.Direction;
import org.devathon.contest2016.Structures.Structure;

public class AddTeleporterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Structure structure = new Structure(Main.teleporter);
        structure.buildStructure(((Player) sender).getLocation().add(2, 0, 0), Direction.NORTH);
        ArmorStand as = Label.addLabel("Teleporter - Click me to configure", ((Player) sender).getLocation().getBlock().getRelative(2, 0, 0));
        TeleporterManager.addTeleporter(as, false);
        return false;
    }
}
