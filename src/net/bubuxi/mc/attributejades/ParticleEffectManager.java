package net.bubuxi.mc.attributejades;

import com.darkblade12.particleeffect.ParticleEffect;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zekunshen on 1/4/16.
 */
public class ParticleEffectManager {
    AttributeManager aManager;
    private Timer timer;

    public ParticleEffectManager(AttributeManager am) {
        aManager = am;
        timer = new Timer();
        timer.schedule(new ParticleEffectTask(this), 1000L, 1000L);
    }
    public void cancelTimer() {
        timer.cancel();
    }

    public void showEffect() {
        synchronized (aManager.jade0) {
            for (Player p : aManager.jade0) {
                playEffect(p, Jades.fromId(0));
            }
        }
        synchronized (aManager.jade1) {
            for (Player p : aManager.jade1) {
                playEffect(p, Jades.fromId(1));
            }
        }
        synchronized (aManager.jade2) {
            for (Player p : aManager.jade2) {
                playEffect(p, Jades.fromId(2));
            }
        }
        synchronized (aManager.jade3) {
            for (Player p : aManager.jade3) {
                playEffect(p, Jades.fromId(3));
            }
        }
        synchronized (aManager.jade4) {
            for (Player p : aManager.jade4) {
                playEffect(p, Jades.fromId(4));
            }
        }
    }

    private void playEffect(Player player, Jades jade) {
        //Logger.info("Playing Effect");
        switch (jade.getId()) {
            case 0:
                ParticleEffect.REDSTONE.display(1L, 1L, 1L, 1L, 10, player.getLocation(), 40);
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;
        }
    }
    private class ParticleEffectTask extends TimerTask {
        private ParticleEffectManager peManager;
        public ParticleEffectTask(ParticleEffectManager pem) {
            peManager = pem;
        }
        @Override
        public void run() {
            peManager.showEffect();
        }
    }
}
