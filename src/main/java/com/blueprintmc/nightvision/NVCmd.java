package com.blueprintmc.nightvision;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NVCmd implements CommandExecutor
{
	private BPNightVision plugin;

	public NVCmd(BPNightVision plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		/* Only players can use this command */
		if (!(sender instanceof Player))
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.MUST_BE_PLAYER));
			return true;
		}

		/* Permission */
		if (!sender.hasPermission("bpnightvision.nv"))
		{
			sender.sendMessage(plugin.getMessage(BPNVLang.NO_PERMISSION));
			return true;
		}

		Player player = (Player) sender;
		String username = sender.getName();

		switch (args.length)
		{
			case 0:
				if (plugin.hasNightVision(username))
				{
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					plugin.players.remove(username);
					player.sendMessage(plugin.getMessage(BPNVLang.OFF));
				}
				else
				{
					plugin.players.put(username, player);
					player.addPotionEffect(
							new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
					player.sendMessage(plugin.getMessage(BPNVLang.ON));
				}
				break;
			case 1:
				switch (args[0].toLowerCase())
				{
					case "help":
						player.sendMessage(plugin.getMessage(BPNVLang.HELP));
						break;
					case "on":
						if (plugin.hasNightVision(username))
						{
							player.sendMessage(plugin.getMessage(BPNVLang.HAS_NIGHT_VISION));
						}
						else
						{
							plugin.players.put(username, player);
							player.addPotionEffect(
									new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
							player.sendMessage(plugin.getMessage(BPNVLang.ON));
						}
						break;
					case "off":
						if (!plugin.hasNightVision(username))
						{
							/* Player already does not have night vision! */
							sender.sendMessage(plugin.getMessage(BPNVLang.NO_NIGHT_VISION));
						}
						else
						{
							player.removePotionEffect(PotionEffectType.NIGHT_VISION);
							plugin.players.remove(username);
							player.sendMessage(plugin.getMessage(BPNVLang.OFF));
						}
						break;
					case "version":
						player.sendMessage("");
						player.sendMessage(plugin.getMessage(BPNVLang.VERSION));
						player.sendMessage("");
						break;
					default:
						player.sendMessage(plugin.getMessage(BPNVLang.INVALID));
						break;
				}
				break;
			default:
				player.sendMessage(plugin.getMessage(BPNVLang.INVALID));
				break;
		}

		return true;
	}
}