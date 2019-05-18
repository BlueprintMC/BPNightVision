package com.blueprintmc.nightvision;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BPNightVisionTask implements Runnable
{
	private BPNightVision plugin;

	public BPNightVisionTask(BPNightVision plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void run()
	{
		for (Player p : plugin.players.values())
		{
			if (p.isOnline())
			{
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
			}
		}
	}
}