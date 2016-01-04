package net.bubuxi.mc.attributejades;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zekunshen on 1/4/16.
 */
public enum Jades {
    EVASION_JADE("闪避护符", 0),
    ATTACK_JADE("攻击护符", 1),
    CRITICAL_JADE("暴击护符", 2),
    PROTECTION_JADE("保护护符", 3),
    AGILITY_JADE("敏捷护符", 4);

    private String name;
    private int id;
    private int level;
    private static HashMap<Integer, Jades> ID_MAP = new HashMap<Integer, Jades>();
    private static HashMap<String, Jades> NAME_MAP = new HashMap<String, Jades>();

    public static ItemStack jade0 = Util.getItemStack(Material.DIAMOND, 1, "&6闪避护符", "&a护符属性;&5提供闪避: +10%;&a等级:1");
    public static ItemStack jade1 = Util.getItemStack(Material.DIAMOND, 1, "&6攻击护符", "&a护符属性;&5攻击加成: +10%;&a等级:1");
    public static ItemStack jade2 = Util.getItemStack(Material.DIAMOND, 1, "&6暴击护符", "&a护符属性;&5暴击几率: +10%;&a等级:1");
    public static ItemStack jade3 = Util.getItemStack(Material.DIAMOND, 1, "&6保护护符", "&a护符属性;&5伤害降低: +%10;&a等级:1");
    public static ItemStack jade4 = Util.getItemStack(Material.DIAMOND, 1, "&6敏捷护符", "&a护符属性;&5速度加成: +%10;&a等级:1");


    // Initialize map for quick name and id lookup
    static {
        for (Jades jade : values()) {
            NAME_MAP.put(jade.name, jade);
            ID_MAP.put(jade.id, jade);
        }
    }

    Jades(String n, int i) {
        name = n;
        id = i;
        level = 1;
    }

    Jades(int t, int l) {
        id = t;
        level = l;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItemStack() {
        switch (id) {
            case 0:
                return jade0.clone();
            case 1:
                return jade1.clone();
            case 2:
                return jade2.clone();
            case 3:
                return jade3.clone();
            case 4:
                return jade4.clone();
            default:
                return null;
        }

    }

    public static boolean isJade(ItemStack is) {
        if(is!=null&&is.hasItemMeta()&&is.getItemMeta().hasDisplayName()&&is.getItemMeta().hasLore()) {
            List<String> lore = is.getItemMeta().getLore();
            for(Iterator<String> it = lore.iterator();it.hasNext();) {
                String s = it.next();
                if(s.equals(ChatColor.translateAlternateColorCodes('&', "&a护符属性"))) return true;
            }
        }
        return false;
    }

    public static Jades getType(ItemStack is) {
        if(isJade(is)) {
            return NAME_MAP.get(is.getItemMeta().getDisplayName().substring(2));
        }
        return null;
    }

    public static Jades fromName(String name) {
        return NAME_MAP.get(name);
    }

    public static Jades fromId(int id) {
        return ID_MAP.get(id);
    }



}
