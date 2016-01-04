package net.bubuxi.mc.attributejades;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zekunshen on 1/4/16.
 */
public class AttributeManager{
    AttributeJades plugin;

    private Timer timer = new Timer();

    List<Player> jade0;
    List<Player> jade1;
    List<Player> jade2;
    List<Player> jade3;
    List<Player> jade4;

    public AttributeManager(AttributeJades aj) {
        plugin = aj;
        jade0 = new ArrayList<Player>();
        jade1 = new ArrayList<Player>();
        jade2 = new ArrayList<Player>();
        jade3 = new ArrayList<Player>();
        jade4 = new ArrayList<Player>();
        timer.schedule(new UpdateTask(this), 1000L, 1000L);
    }

    public void cancelTimer() {
        timer.cancel();
    }

    public void update() {
        synchronized (jade0) {
            jade0.clear();
        }
        synchronized (jade1) {
            jade1.clear();
        }
        synchronized (jade2) {
            jade2.clear();
        }
        synchronized (jade3) {
            jade3.clear();
        }
        synchronized (jade4) {
            jade4.clear();
        }
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getInventory().contains(Jades.jade0)) {
                synchronized (jade0) {
                    jade0.add(p);
                }
            }
            if(p.getInventory().contains(Jades.jade1)) {
                synchronized (jade1) {
                    jade1.add(p);
                }
            }
            if(p.getInventory().contains(Jades.jade2)) {
                synchronized (jade2) {
                    jade2.add(p);
                }
            }
            if(p.getInventory().contains(Jades.jade3)) {
                synchronized (jade3) {
                    jade3.add(p);
                }
            }
            if(p.getInventory().contains(Jades.jade4)) {
                synchronized (jade4) {
                    jade4.add(p);
                }
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
