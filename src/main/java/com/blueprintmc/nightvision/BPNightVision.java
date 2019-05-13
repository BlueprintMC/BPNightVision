package com.blueprintmc.nightvision;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class BPNightVision extends JavaPlugin
{
    private BPNightVisionTask task;

    public ArrayList<Player> players;

    public BPNightVision()
    {
        task = new BPNightVisionTask(this);
    }

    @Override
    public void onEnable()
    {
        /* /nv command */
        getCommand("nv").setExecutor(new NVCmd(this));

        /* Night vision refresh task every 5 seconds */
        getServer().getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 100L);
    }

    @Override
    public void onDisable()
    {

    }
}