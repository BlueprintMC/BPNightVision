package com.blueprintmc.nightvision;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class BPNightVision extends JavaPlugin
{
	private BPNightVisionTask task;

	public HashMap<String, Player> players;

	public static final String VERSION = "1.1.0";

	public BPNightVision()
	{
		task = new BPNightVisionTask(this);
		players = new HashMap<String, Player>();
	}

	@Override
	public void onEnable()
	{
		/* /nv command */
		getCommand("nv").setExecutor(new NVCmd(this));
		getCommand("nvlist").setExecutor(new NVListCmd(this));

		/* Listeners */
		getServer().getPluginManager().registerEvents(new BPNVQuitListener(this), this);

		/* Night vision refresh task every 5 seconds */
		getServer().getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 100L);
	}

	@Override
	public void onDisable()
	{
		for (Player p : players.values())
		{
			if (p.isOnline())
			{
				p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			}
		}
	}

	public String getMessage(BPNVLang value)
	{
		return ChatColor.translateAlternateColorCodes('&', value.getValue());
	}

	public boolean hasNightVision(String username)
	{
		return players.get(username) != null;
	}
}