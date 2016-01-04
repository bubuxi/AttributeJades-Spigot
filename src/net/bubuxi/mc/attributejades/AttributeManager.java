package net.bubuxi.mc.attributejades;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zekunshen on 1/4/16.
 */
public class AttributeManager{
    AttributeJades plugin;
    List<Player> jade0 = new CopyOnWriteArrayList<Player>();
    List<Player> jade1 = new CopyOnWriteArrayList<Player>();
    List<Player> jade2 = new CopyOnWriteArrayList<Player>();
    List<Player> jade3 = new CopyOnWriteArrayList<Player>();
    List<Player> jade4 = new CopyOnWriteArrayList<Player>();
    private Timer timer = new Timer();

    public AttributeManager(AttributeJades aj) {
        plugin = aj;
        timer.schedule(new UpdateTask(this), 1000L, 1000L);
    }

    public void cancelTimer() {
        timer.cancel();
    }

    public void update() {
        jade0.clear();
        jade1.clear();
        jade2.clear();
        jade3.clear();
        jade4.clear();
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getInventory().contains(Jades.jade0)) {
                jade0.add(p);
            }
            if(p.getInventory().contains(Jades.jade1)) {
                jade1.add(p);
            }
            if(p.getInventory().contains(Jades.jade2)) {
                jade2.add(p);
            }
            if(p.getInventory().contains(Jades.jade3)) {
                jade3.add(p);
            }
            if(p.getInventory().contains(Jades.jade4)) {
                jade4.add(p);
            }
        }
    }

    private class UpdateTask extends TimerTask {
        AttributeManager manager;
        public UpdateTask(AttributeManager am) {
            manager = am;
        }

        @Override
        public void run() {
            manager.update();
        }
    }


}
