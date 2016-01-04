package net.bubuxi.mc.attributejades;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by zekunshen on 1/4/16.
 */
public class AJCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("attributejades")) {
            if(strings.length==2&&strings[0].equalsIgnoreCase("get")){
                if(commandSender.isOp() && commandSender instanceof Player) {
                    Player p = (Player)commandSender;
                    p.getInventory().addItem(Jades.fromId(Integer.parseInt(strings[1])).getItemStack());
                }
            }

        }
        return false;
    }
}
