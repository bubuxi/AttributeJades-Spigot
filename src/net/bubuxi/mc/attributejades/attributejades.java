package net.bubuxi.mc.attributejades;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by zekunshen on 1/4/16.
 */
public class AttributeJades extends JavaPlugin {
    AJCommand ajc;
    AttributeManager am;
    ParticleEffectManager pem;

    public void onEnable() {
        ajc = new AJCommand();
        getCommand("attributejades").setExecutor(ajc);
        am = new AttributeManager(this);
        pem = new ParticleEffectManager(am);
    }

    public void onDisable() {
        am.cancelTimer();
        pem.cancelTimer();
    }

}
