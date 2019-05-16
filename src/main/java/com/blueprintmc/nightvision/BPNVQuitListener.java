package com.blueprintmc.nightvision;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

public class BPNVQuitListener implements Listener
{
	private BPNightVision plugin;

	public BPNVQuitListener(BPNightVision plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		plugin.players.remove(p.getName());
	}
}